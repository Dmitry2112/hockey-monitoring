package org.example.hockeymonitoring.modules.user.controllers;

import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.user.models.User;
import org.example.hockeymonitoring.modules.user.services.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("save_user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("update_user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("delete_user/{id}")
    @Transactional
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
