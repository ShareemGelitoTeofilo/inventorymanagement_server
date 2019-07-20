package inventorymanagementserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signUpUser(User user) throws Exception {
        User existingUserWithSameUsername = userRepository.findByUsername(user.getUsername());
        if(existingUserWithSameUsername != null){
            throw new Exception("Username already exist");
        }
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null){
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public User findById(Long id) throws Exception {
        String message = String.format("User with ID %s not found", id);
        return userRepository.findById(id).orElseThrow(() -> new Exception(message));
    }

    @Override
    public User findByUsername(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        if(user == null){
            String message = String.format("User with username %s not found", username);
            throw new Exception(message);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) throws Exception {
        findById(user.getId());
        User existingUserWithSameName = userRepository.findByUsername(user.getUsername());
        if(existingUserWithSameName != null && !existingUserWithSameName.equals(user)){
            throw new Exception("Username already taken");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        findById(id);
        userRepository.deleteById(id);
    }
}
