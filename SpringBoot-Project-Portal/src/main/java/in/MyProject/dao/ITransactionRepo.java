package in.MyProject.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.MyProject.model.Transaction;
@Transactional
public interface ITransactionRepo extends MongoRepository<Transaction, String> {
	
	public List<Transaction> findByStatus(String status);
	public List<Transaction> findByLibraryIdAndStatus(@Param("libraryId") String libraryId,@Param("status") String status);
}
