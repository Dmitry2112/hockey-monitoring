package org.example.hockeymonitoring.modules.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.shared.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Response<List<User>> getList() throws JsonProcessingException {
        List<User> users = userService.getList();
        return new Response<>(users);
    }

    @GetMapping("/{id}")
    public Response<User> getOne(@PathVariable Long id) {
        User user = userService.getOne(id);
        return new Response<>(user);
    }

    @PostMapping
    public Response<User> create(@RequestBody User user) {
        User userCreated = userService.create(user);
        return new Response<>(userCreated);
    }

    @PatchMapping("/{id}")
    public Response<User> patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        User user = userService.patch(id, patchNode);
        return new Response<>(user);
    }

    @DeleteMapping("/{id}")
    public Response<User> delete(@PathVariable Long id) {
        User user = userService.delete(id);
        return new Response<>(user);
    }
}
