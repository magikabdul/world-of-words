package cloud.cholewa.wow.foster.boundary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class FosterRegister {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
