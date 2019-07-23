package inventorymanagementserver.user;

import inventorymanagementserver.exception.InventoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static String NOT_FOUND = "User not found";
    @Autowired
    private UserRepository userRepository;

    @Override
    public User signUp(User user) {
        User existingUserWithSameUsername = userRepository.findByUsername(user.getUsername());
        if (existingUserWithSameUsername != null) {
            throw new InventoryException("Username already exist");
        }
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            throw new InventoryException(NOT_FOUND);
        }
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new InventoryException(NOT_FOUND));
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new InventoryException(NOT_FOUND);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        User userToUpdate = findById(user.getId());
        User existingUserWithSameName = userRepository.findByUsername(user.getUsername());
        if (existingUserWithSameName != null && !existingUserWithSameName.equals(user)) {
            throw new InventoryException("Username already taken");
        }

        userToUpdate.setName(user.getName());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setUsername(user.getUsername());
        if (user.getPassword() != null) {
            userToUpdate.setPassword(user.getPassword());
        }
        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new InventoryException(NOT_FOUND);
        }
        userRepository.deleteById(id);
    }
}
