package cloud.cholewa.wow.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String password;

    private String email;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private String roles;

    private LocalDateTime createdAt;
    private LocalDateTime lastSeenAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        StringBuilder allRoles = new StringBuilder(roles.trim());

        while (allRoles.length() > 0) {
            int position = allRoles.indexOf(",");

            String r;
            if (position > -1) {
                r = allRoles.substring(0, position).trim().toUpperCase();
                allRoles.delete(0, position + 1);
            } else {
                r = allRoles.substring(0).trim().toUpperCase();
                allRoles.setLength(0);
            }

            authorities.add(new SimpleGrantedAuthority("ROLE_" + r));
        }

        return authorities;
    }
}
