
package blooddonation;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Integer> {

    List<Donor> findByBloodGroupIgnoreCaseAndAvailabilityIgnoreCase(
            String bloodGroup, String availability);
}