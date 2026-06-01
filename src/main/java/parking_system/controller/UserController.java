package parking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import parking_system.model.User;
import parking_system.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Add User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
   
        return userRepository.findAll();
    }
    // LOGIN USER

@PostMapping("/login")
public User loginUser(@RequestBody User loginData) {

    return userRepository.findByEmailAndPassword(
            loginData.getEmail(),
            loginData.getPassword()
    );
}
    @GetMapping("/test")
public String testApi() {
    return "User API Working";
}

}