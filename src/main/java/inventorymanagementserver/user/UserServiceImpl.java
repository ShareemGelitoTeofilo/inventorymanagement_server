package inventorymanagementserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
