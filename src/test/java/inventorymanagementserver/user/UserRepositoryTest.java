package inventorymanagementserver.user;

import inventorymanagementserver.ServerMainClassTest;
import inventorymanagementserver.User;
import inventorymanagementserver.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class UserRepositoryTest extends ServerMainClassTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveUser(){
        User user = createUser();
        assertNotNull(userRepository.save(user));
    }

    @Test
    public void findUserByUsernameAndPassword(){
        User user = createUser();
        user = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        assertNotNull(user);
    }

    @Test
    public void findUserById(){
        User user = createSavedUser();
        user = userRepository.findById(user.getId()).get();
        assertNotNull(user);
    }

    @Test
    public void findAllUsers(){
        List<User> users = userRepository.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    public void updateUser(){
        User user = createSavedUser();
        user.setAddress("new address");
        user.setName("new name");
        user.setPassword("new password");
        user.setUsername("new username");
        user = userRepository.save(user);
        assertNotNull(user);
    }

    @Test
    public void deleteUser(){
        User user = createSavedUser();
        userRepository.deleteById(user.getId());
    }


    private User createUser(){
        return new User("name", "address", "username", "password");
    }

    private User createSavedUser(){
        User user = new User("name", "address", "username", "password");
        return userRepository.save(user);
    }

}
