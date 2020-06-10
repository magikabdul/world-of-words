package cloud.cholewa.wow.user.boundary;

import lombok.Data;

@Data
public class UserLogin {
    private String login;
    private String password;
}
