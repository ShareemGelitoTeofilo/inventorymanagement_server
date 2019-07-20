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
    public User signUpUser(@RequestBody User user) throws Exception {
        return userService.signUpUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginForm loginForm) throws Exception {
        return userService.login(loginForm.getUsername(), loginForm.getPassword());
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id) throws Exception {
        return userService.findById(id);
    }

    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) throws Exception {
        return userService.findByUsername(username);
    }

    @GetMapping("/findAll")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) throws Exception {
        return userService.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) throws Exception {
        userService.deleteById(id);
    }


}
