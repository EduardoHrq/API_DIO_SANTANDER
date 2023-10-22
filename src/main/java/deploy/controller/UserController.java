package deploy.controller;

import deploy.model.User;
import deploy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController (UserService servico) {
        this.userService = servico;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User usuario) {
        var user = this.userService.create(usuario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        var user = this.userService.findById(id);

        return ResponseEntity.ok(user);
    }

}
