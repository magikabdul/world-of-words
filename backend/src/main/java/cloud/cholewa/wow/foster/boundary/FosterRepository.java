package cloud.cholewa.wow.foster.boundary;

import cloud.cholewa.wow.foster.entity.Foster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FosterRepository extends JpaRepository<Foster, Long> {

    Optional<Foster> findByMail(String mail);
}
