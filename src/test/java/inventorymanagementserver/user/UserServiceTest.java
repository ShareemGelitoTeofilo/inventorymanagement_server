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



}
