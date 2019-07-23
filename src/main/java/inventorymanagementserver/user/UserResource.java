package inventorymanagementserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginForm loginForm) {
        return userService.login(loginForm.getUsername(), loginForm.getPassword());
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
