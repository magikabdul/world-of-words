package cloud.cholewa.wow.foster.service;

import cloud.cholewa.wow.exceptions.AccountCreationException;
import cloud.cholewa.wow.foster.boundary.FosterRegister;
import cloud.cholewa.wow.foster.boundary.FosterRepository;
import cloud.cholewa.wow.foster.boundary.FosterResponse;
import cloud.cholewa.wow.foster.entity.Foster;
import cloud.cholewa.wow.user.entity.ActivateToken;
import cloud.cholewa.wow.user.entity.User;
import cloud.cholewa.wow.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FosterService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final FosterRepository fosterRepository;


    public FosterResponse add(FosterRegister fosterRegister) {

        if (userService.isUserRegistered(fosterRegister.getUsername(), fosterRegister.getEmail())) {
            throw new AccountCreationException("Account already exists");
        }

        User user = new User();

        user.setUsername(fosterRegister.getUsername());
        user.setPassword(passwordEncoder.encode(fosterRegister.getPassword()));
        user.setEmail(fosterRegister.getEmail());
        user.setRoles("FOSTER");
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setEnabled(false);
        user.setFirstName(fosterRegister.getFirstName());
        user.setLastName(fosterRegister.getLastName());
        user.setCreatedAt(LocalDateTime.now());

        User newUser = userService.addUser(user);

        ActivateToken activateToken = new ActivateToken();
        activateToken.setToken(UUID.randomUUID().toString());
        activateToken.setUser(user);

        Foster foster = new Foster();
        foster.setUser(user);

        userService.addToken(activateToken);

        userService.sendActivationEmail(user.getEmail(), activateToken.getToken());

        Foster newFoster = fosterRepository.save(foster);

        return FosterResponse.builder()
                .id(newFoster.getId())
                .fistName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .username(newUser.getUsername())
                .email(newUser.getEmail())
                .build();
    }
}
