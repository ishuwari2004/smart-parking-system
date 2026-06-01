package parking_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import parking_system.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmailAndPassword(String email, String password);

}