package cloud.cholewa.wow.user.service;

import cloud.cholewa.wow.user.boundary.UserRepository;
import cloud.cholewa.wow.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsApplicationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUserByUsername = userRepository.findByUsername(s);
        Optional<User> optionalUserByEmail = userRepository.findByEmail(s);

        if (optionalUserByUsername.isPresent()) {
            return optionalUserByUsername.get();
        } else if (optionalUserByEmail.isPresent()) {
            return optionalUserByEmail.get();
        }

        throw new UsernameNotFoundException("User not found");
    }
}
