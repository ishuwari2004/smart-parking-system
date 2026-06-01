package parking_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import parking_system.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {

}