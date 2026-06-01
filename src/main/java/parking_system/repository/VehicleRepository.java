package parking_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import parking_system.model.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
     Vehicle findByVehicleNumber(String vehicleNumber);

}