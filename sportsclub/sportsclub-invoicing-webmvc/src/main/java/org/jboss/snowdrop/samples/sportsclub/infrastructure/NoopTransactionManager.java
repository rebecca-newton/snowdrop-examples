package org.jboss.snowdrop.samples.sportsclub.infrastructure;

import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * Created by IntelliJ IDEA.
 * User: marius
 * Date: 7-Jan-2010
 * Time: 3:38:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoopTransactionManager extends JtaTransactionManager
{

	@Override
	public Transaction createTransaction(String name, int timeout)
			throws NotSupportedException, SystemException
   {
      Transaction transaction = this.getTransactionManager().getTransaction();

      if (transaction != null && (transaction.getStatus() != Status.STATUS_NO_TRANSACTION))
			return transaction;
		else {
			return super.createTransaction(name, timeout);
      }
	}




}
