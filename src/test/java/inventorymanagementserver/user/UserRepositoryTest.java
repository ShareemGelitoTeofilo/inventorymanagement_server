package inventorymanagementserver.user;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.TestHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class UserRepositoryTest extends ServerMainClassTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestHelper testHelper;

    @Test
    public void saveUser(){
        User user = testHelper.createUser();
        assertNotNull(userRepository.save(user));
    }

    @Test
    public void findUserByUsernameAndPassword(){
        User user = testHelper.createSavedUser();
        user = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        assertNotNull(user);
    }

    @Test
    public void findUserById(){
        User user = testHelper.createSavedUser();
        user = userRepository.findById(user.getId()).get();
        assertNotNull(user);
    }

    @Test
    public void findUserByName(){
        String username = testHelper.createSavedUser().getUsername();
        User user = userRepository.findByUsername(username);
        assertNotNull(user);
    }

    @Test
    public void findAllUsers(){
        List<User> users = userRepository.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    public void updateUser(){
        User user = testHelper.createSavedUser();
        user.setAddress("new address");
        user.setName("new name");
        user.setPassword("new password");
        user.setUsername("new username");
        user = userRepository.save(user);
        assertNotNull(user);
    }

    @Test
    public void deleteUser(){
        User user = testHelper.createSavedUser();
        userRepository.deleteById(user.getId());
    }

}
