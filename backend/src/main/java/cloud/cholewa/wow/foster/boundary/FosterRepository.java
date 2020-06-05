package cloud.cholewa.wow.foster.boundary;

import cloud.cholewa.wow.foster.entity.Foster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FosterRepository extends JpaRepository<Foster, Long> {

}
