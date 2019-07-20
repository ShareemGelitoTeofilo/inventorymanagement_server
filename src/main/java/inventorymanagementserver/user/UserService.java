package inventorymanagementserver.user;

import java.util.List;

public interface UserService {
    User signUpUser(User user) throws Exception;
    User login(String username, String password) throws Exception;
    User findById(Long id) throws Exception;
    User findByUsername(String username) throws Exception;
    List<User> findAll();
    User update(User user) throws Exception;
    void deleteById(Long id) throws Exception;
}
