package app.hesias.WeatherTogether.Controller;

import app.hesias.WeatherTogether.Model.Utilisateur;
import app.hesias.WeatherTogether.Service.Utilisateur.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UtilisateurService userService;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody Utilisateur user) {
        userService.createUser(user);
    }

    @PostMapping("/list")
    public void createUsers(@RequestBody List<Utilisateur> users) {
        userService.createUsers(users);
    }

    @GetMapping("/{id}")
    public Utilisateur getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUser(@PathVariable int id, @RequestBody Utilisateur user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}