package inventorymanagementserver.user;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class UserServiceTest extends ServerMainClassTest {

    @Autowired
    private UserService userService;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void signUpUser() throws Exception {
        User user = testHelper.createUser();
        user = userService.signUpUser(user);
        assertNotNull(user);
    }

    @Test
    public void loginUser() throws Exception {
        User user = testHelper.createSavedUser();
        user = userService.login(user.getUsername(), user.getPassword());
        assertNotNull(user);
    }

    @Test
    public void findById() throws Exception {
        User user = testHelper.createSavedUser();
        user = userService.findById(user.getId());
        assertNotNull(user);
    }

    @Test
    public void findByUsername() throws Exception {
        User user = testHelper.createSavedUser();
        user = userService.findByUsername(user.getUsername());
        assertNotNull(user);
    }
}
