package in.MyProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.MyProject.dao.ITransactionRepo;
import in.MyProject.model.Transaction;

@Service

public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private ITransactionRepo repo;

	@Override
	public String SaveTransaction(Transaction transaction) {
		Transaction save = repo.save(transaction);
		if (save!=null) {
			return "done";
		} else {
			return "fail";
		}
	}

	@Override
	public List<Transaction> getTransactionByStatus(String libraryId, String Status) {
		return repo.findByLibraryIdAndStatus(libraryId,Status);
	}

	@Override
	public List<Transaction> getAllTransactionByStatus(String Status) {
		return repo.findByStatus(Status);
	}

	@Override
	public String updateTransaction(Transaction transaction) {
		Transaction save = repo.save(transaction);
		if (save != null) 
			return "done" ;
			
		else
		return "fail";
	}

	@Override
	public Transaction getTransaction(String libraryId) {
		Optional<Transaction> optional = repo.findById(libraryId);
		if (optional.isPresent()) {
			Transaction transaction = optional.get();
			return transaction;
		}
		return null;
	}

	@Override
	public void deleteTransaction(String libraryId) {
		repo.deleteById(libraryId);
	}

}
