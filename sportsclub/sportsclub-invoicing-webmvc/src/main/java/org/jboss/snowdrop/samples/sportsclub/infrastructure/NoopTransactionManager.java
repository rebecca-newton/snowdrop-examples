package org.jboss.snowdrop.samples.sportsclub.infrastructure;

import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.springframework.transaction.jta.JtaTransactionManager;

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
