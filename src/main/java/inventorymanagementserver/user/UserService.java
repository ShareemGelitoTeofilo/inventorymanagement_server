package inventorymanagementserver.user;

import java.util.List;

public interface UserService {
    User signUp(User user);
    User login(String username, String password);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    User update(User user);
    void deleteById(Long id);
}
