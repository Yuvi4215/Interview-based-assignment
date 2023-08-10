package in.MyProject.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import in.MyProject.model.Admin;
@Transactional
public interface IAdminRepo extends MongoRepository<Admin, String> {

}
