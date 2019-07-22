package inventorymanagementserver.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class LoginForm {
    private String username;
    private String password;
}
