package soft.softfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.softfinal.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
