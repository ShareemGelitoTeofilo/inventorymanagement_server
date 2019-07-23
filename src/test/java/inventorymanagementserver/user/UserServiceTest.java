package inventorymanagementserver.user;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest extends ServerMainClassTest {

    @Autowired
    private UserService userService;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void signUp() {
        User user = testHelper.getUser();
        user = userService.signUp(user);
        assertNotNull(user);
    }

    @Test
    public void login() {
        User user = testHelper.createUser();
        user = userService.login(user.getUsername(), user.getPassword());
        assertNotNull(user);
    }

    @Test
    public void findById() {
        User user = testHelper.createUser();
        user = userService.findById(user.getId());
        assertNotNull(user);
    }

    @Test
    public void findByUsername() {
        User user = testHelper.createUser();
        user = userService.findByUsername(user.getUsername());
        assertNotNull(user);
    }

    @Test
    public void findAll() {
        List<User> users = userService.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    public void update() {
        User user = testHelper.createUser();
        String username = UUID.randomUUID().toString().substring(0, 8);
        user.setUsername(username);
        user.setPassword("new password");
        user = userService.update(user);
        assertNotNull(user);
    }

    @Test
    public void deleteById() {
        User user = testHelper.createUser();
        userService.deleteById(user.getId());
    }
}
