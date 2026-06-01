package parking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import parking_system.model.Vehicle;
import parking_system.repository.VehicleRepository;

import java.util.List;

import parking_system.model.ParkingSlot;
import parking_system.repository.ParkingSlotRepository;
import parking_system.service.EmailService;

@RestController
@RequestMapping("/api/vehicles")

public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
private ParkingSlotRepository parkingSlotRepository;
    @Autowired
    private EmailService emailService;

   // ADD VEHICLE

@PostMapping
public Vehicle addVehicle(@RequestBody Vehicle vehicle) {

    ParkingSlot slot =
            parkingSlotRepository.findBySlotNumber(
                    vehicle.getSlotNumber()
            );

    if (slot != null) {

        slot.setStatus("Occupied");

        parkingSlotRepository.save(slot);
    }
    emailService.sendEmail(

        "yashodhaniishuwari@gmail.com",

        "Vehicle Entry Notification",

        "Vehicle " +
                vehicle.getVehicleNumber() +
                " entered parking slot " +
                vehicle.getSlotNumber()
);

ParkingSlot availableSlot =
        parkingSlotRepository
                .findFirstByStatus("AVAILABLE");

if (availableSlot != null) {

    vehicle.setSlotNumber(
            availableSlot.getSlotNumber()
    );

    availableSlot.setStatus("OCCUPIED");

    parkingSlotRepository.save(
            availableSlot
    );
}

    return vehicleRepository.save(vehicle);
}

    // GET ALL VEHICLES

    @GetMapping
    public List<Vehicle> getAllVehicles() {

        return vehicleRepository.findAll();
    }

    // SEARCH VEHICLE

    @GetMapping("/search/{vehicleNumber}")
    public Vehicle searchVehicle(@PathVariable String vehicleNumber) {

        return vehicleRepository.findByVehicleNumber(vehicleNumber);
    }

    // VEHICLE EXIT

    @PutMapping("/exit/{id}")
    public Vehicle vehicleExit(@PathVariable String id,
                               @RequestBody Vehicle updatedVehicle) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle != null) {

            vehicle.setExitTime(updatedVehicle.getExitTime());

            vehicle.setStatus(updatedVehicle.getStatus());
            
            ParkingSlot slot =
        parkingSlotRepository.findBySlotNumber(
                vehicle.getSlotNumber()
        );

if (slot != null) {

    slot.setStatus("Available");

    parkingSlotRepository.save(slot);
}

            return vehicleRepository.save(vehicle);
        }

        return null;
    }
    // DELETE VEHICLE

@DeleteMapping("/{id}")
public String deleteVehicle(@PathVariable String id) {

    vehicleRepository.deleteById(id);

    return "Vehicle Deleted Successfully";
}
// UPDATE VEHICLE

@PutMapping("/update/{id}")
public Vehicle updateVehicle(@PathVariable String id,
                             @RequestBody Vehicle updatedVehicle) {

    Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

    if (vehicle != null) {

        vehicle.setVehicleType(updatedVehicle.getVehicleType());

        vehicle.setOwnerName(updatedVehicle.getOwnerName());

        vehicle.setStatus(updatedVehicle.getStatus());

        return vehicleRepository.save(vehicle);
    }

    return null;
}
}