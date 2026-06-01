package parking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import parking_system.model.ParkingSlot;
import parking_system.repository.ParkingSlotRepository;

import java.util.List;

@RestController
@RequestMapping("/api/slots")

public class ParkingSlotController {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    // Add Parking Slot
    @PostMapping
    public ParkingSlot createSlot(@RequestBody ParkingSlot slot) {
        return parkingSlotRepository.save(slot);
    }

    // Get All Parking Slots
    @GetMapping
    public List<ParkingSlot> getAllSlots() {
        return new java.util.ArrayList<>();
    }
}