package parking_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import parking_system.model.ParkingSlot;

public interface ParkingSlotRepository extends MongoRepository<ParkingSlot, String> {

 ParkingSlot findBySlotNumber(String slotNumber);

 ParkingSlot findFirstByStatus(String status);

}