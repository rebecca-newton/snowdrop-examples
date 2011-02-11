package org.jboss.snowdrop.samples.sportsclub.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * @author Marius Bogoevici
 */
@SuppressWarnings("rawtypes")
public class TestDatasourceFactoryBean implements FactoryBean, ResourceLoaderAware
{

   private Resource databaseSetupFile;

   private String url;
   private String driverClassName;
   private String username;
   private String password;
   private BasicDataSource dataSource;
   private ResourceLoader resourceLoader;
   private String databaseSetupFileName;

   public void setUrl(String url)
   {
      this.url = url;

   }

   /*public void setDatabaseSetupFile(Resource databaseSetupFile)
   {
      this.databaseSetupFile = databaseSetupFile;
   }*/


   public void setResourceLoader(ResourceLoader resourceLoader)
   {
      this.resourceLoader = resourceLoader;
   }

   public void setDatabaseSetupFile(String databaseSetupFileName)
   {
      this.databaseSetupFileName = databaseSetupFileName;
   }

   public void setDriverClassName(String driverClassName)
   {
      this.driverClassName = driverClassName;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public Object getObject() throws Exception
   {
      return dataSource;
   }

   public Class<DataSource> getObjectType()
   {
      return DataSource.class;
   }

   public boolean isSingleton()
   {
      return true;
   }

   @SuppressWarnings("unchecked")
   @PostConstruct
   public void doAfterConstruction()
   {
      this.databaseSetupFile = resourceLoader.getResource(databaseSetupFileName);
      dataSource = new BasicDataSource();
      dataSource.setUrl(url);
      dataSource.setUsername(username);
      dataSource.setDriverClassName(driverClassName);
      dataSource.setPassword(password);

      PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
      final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

      new TransactionTemplate(transactionManager).execute(new TransactionCallback()
      {
         public Object doInTransaction(TransactionStatus status)
         {
            try
            {
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(databaseSetupFile.getInputStream()));
               String sqlCommand;
               while ((sqlCommand = bufferedReader.readLine()) != null)
               {
                  jdbcTemplate.execute(sqlCommand);
               }
            }
            catch (IOException e)
            {
               throw new RuntimeException(e);
            }
            return null;
         }
      });
   }

   @PreDestroy
   public void doBeforeShutdown()
   {
      try
      {
         dataSource.close();
      }
      catch (SQLException e)
      {
         throw new RuntimeException(e);
      }
   }

}
