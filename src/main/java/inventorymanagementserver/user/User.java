package inventorymanagementserver.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String username;
    private String password;
    private UserType type;

    protected User() {}

    public User(String name, String address, String username, String password, UserType type) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.type = type;
    }
}
