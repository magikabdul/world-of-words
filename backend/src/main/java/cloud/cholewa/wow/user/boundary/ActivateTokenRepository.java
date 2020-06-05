package cloud.cholewa.wow.user.boundary;

import cloud.cholewa.wow.user.entity.ActivateToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivateTokenRepository extends JpaRepository<ActivateToken, Long> {

    Optional<ActivateToken> findActivateTokenByToken(String token);
}
