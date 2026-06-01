package parking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import parking_system.repository.VehicleRepository;
import parking_system.repository.ParkingSlotRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")

public class DashboardController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @GetMapping
    public Map<String, Long> getDashboardData() {

        Map<String, Long> dashboard = new HashMap<>();

        dashboard.put("totalVehicles", vehicleRepository.count());

        dashboard.put("totalSlots", parkingSlotRepository.count());

        return dashboard;
    }
}