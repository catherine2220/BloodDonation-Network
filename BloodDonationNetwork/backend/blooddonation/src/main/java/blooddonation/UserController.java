package blooddonation;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User signup(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public java.util.List<User> getUsers() {
        return userRepository.findAll();
    }
}