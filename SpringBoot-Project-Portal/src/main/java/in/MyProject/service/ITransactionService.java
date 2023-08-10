package in.MyProject.service;

import java.util.List;

import in.MyProject.model.Transaction;

public interface ITransactionService {
	
	public void deleteTransaction(String libraryId);
	public String SaveTransaction(Transaction transaction);
	public Transaction getTransaction(String libraryId);
	public String updateTransaction(Transaction transaction);
	public List<Transaction> getTransactionByStatus(String libraryId, String Status);
	public List<Transaction> getAllTransactionByStatus( String Status);
}
