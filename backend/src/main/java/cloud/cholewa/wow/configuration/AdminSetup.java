package cloud.cholewa.wow.configuration;

import cloud.cholewa.wow.foster.boundary.FosterRepository;
import cloud.cholewa.wow.foster.entity.Foster;
import cloud.cholewa.wow.user.boundary.UserRepository;
import cloud.cholewa.wow.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "application.admin.configuration")
@Setter
public class AdminSetup {

    private final UserRepository userRepository;
    private final FosterRepository fosterRepository;

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String mail;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostConstruct
    public void addAdmin() {
        if (userRepository.findByUsername(username).isEmpty() && fosterRepository.findByMail(mail).isEmpty()) {
            Foster foster = new Foster();
            User user = new User();

            user.setUsername(username);
            user.setPassword(getPasswordEncoder().encode(password));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setRoles("ADMIN");

            foster.setFirstName(firstName);
            foster.setLastName(lastName);
            foster.setMail(mail);
            foster.setCreatedAt(LocalDateTime.now());
            foster.setUser(user);

            userRepository.save(user);
            fosterRepository.save(foster);
        }
    }
}
