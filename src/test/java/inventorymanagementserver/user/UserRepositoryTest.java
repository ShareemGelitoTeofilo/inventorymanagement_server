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
    public void save(){
        User user = testHelper.getUser();
        assertNotNull(userRepository.save(user));
    }

    @Test
    public void findByUsernameAndPassword(){
        User user = testHelper.createUser();
        user = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        assertNotNull(user);
    }

    @Test
    public void findById(){
        User user = testHelper.createUser();
        user = userRepository.findById(user.getId()).get();
        assertNotNull(user);
    }

    @Test
    public void findByUsername(){
        String username = testHelper.createUser().getUsername();
        User user = userRepository.findByUsername(username);
        assertNotNull(user);
    }

    @Test
    public void findAll(){
        List<User> users = userRepository.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    public void update(){
        User userToUpdate = testHelper.createUser();
        User user = testHelper.getUser();
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setName(user.getName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate = userRepository.save(userToUpdate);
        assertNotNull(userToUpdate);
    }

    @Test
    public void deleteById(){
        User user = testHelper.createUser();
        userRepository.deleteById(user.getId());
    }

}
