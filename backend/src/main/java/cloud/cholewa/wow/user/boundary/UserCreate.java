package cloud.cholewa.wow.user.boundary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserCreate {
    private String username;
    private String password;
    private String email;
}
