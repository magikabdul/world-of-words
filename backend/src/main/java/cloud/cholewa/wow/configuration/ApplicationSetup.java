package cloud.cholewa.wow.configuration;

import cloud.cholewa.wow.foster.boundary.FosterRepository;
import cloud.cholewa.wow.foster.entity.Foster;
import cloud.cholewa.wow.user.boundary.UserRepository;
import cloud.cholewa.wow.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class ApplicationSetup {

    private final UserRepository userRepository;
    private final FosterRepository fosterRepository;
    private final EmailService emailService;
    private final AdminData admin;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostConstruct
    public void addAdmin() {
        if (userRepository.findByUsername(admin.getUsername()).isEmpty() && userRepository.findByEmail(admin.getMail()).isEmpty()) {
            Foster foster = new Foster();
            User user = new User();

            user.setUsername(admin.getUsername());
            user.setPassword(getPasswordEncoder().encode(admin.getPassword()));
            user.setAccountNonExpired(true);
            user.setEmail(admin.getMail());
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setRoles("ADMIN");

            foster.setFirstName(admin.getFirstName());
            foster.setLastName(admin.getLastName());
            foster.setCreatedAt(LocalDateTime.now());
            foster.setUser(user);

            userRepository.save(user);
            fosterRepository.save(foster);
        }

        LocalDateTime time = LocalDateTime.now();
        emailService.send(admin.getMail(), "Application Info", "Wow application started:" + time.toLocalDate() + " " + time.toLocalTime());
    }
}