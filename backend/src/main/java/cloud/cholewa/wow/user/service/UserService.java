package cloud.cholewa.wow.user.service;

import cloud.cholewa.wow.configuration.EmailService;
import cloud.cholewa.wow.exceptions.InvalidActivationToken;
import cloud.cholewa.wow.user.boundary.ActivateTokenRepository;
import cloud.cholewa.wow.user.boundary.UserRepository;
import cloud.cholewa.wow.user.entity.ActivateToken;
import cloud.cholewa.wow.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EmailService emailService;
    private final UserRepository userRepository;
    private final ActivateTokenRepository activateTokenRepository;

    public boolean isUserRegistered(String username, String email) {
        Optional<User> optionalUserByUsername = userRepository.findByUsername(username);
        Optional<User> optionalUserByEmail = userRepository.findByEmail(email);

        return optionalUserByUsername.isPresent() || optionalUserByEmail.isPresent();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public ActivateToken addToken(ActivateToken token) {
        return activateTokenRepository.save(token);
    }

    public void activateUser(String token) {
        Optional<ActivateToken> optionalActivateToken = activateTokenRepository.findActivateTokenByToken(token);

        if (optionalActivateToken.isEmpty())
            throw new InvalidActivationToken("Invalid activation token");

        ActivateToken activateToken = optionalActivateToken.get();

        User user = activateToken.getUser();
        user.setEnabled(true);

        activateTokenRepository.delete(activateToken);
        userRepository.save(user);
    }

    public void sendActivationEmail(String email, String token) {
        emailService.send(email, "Activate your account", "http://localhost:8080/api/activate?token=" + token);
    }
}
