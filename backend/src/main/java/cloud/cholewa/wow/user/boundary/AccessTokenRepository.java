package cloud.cholewa.wow.user.boundary;

import cloud.cholewa.wow.user.entity.AccessToken;
import cloud.cholewa.wow.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {

    Optional<AccessToken> findByUser(User user);
}
