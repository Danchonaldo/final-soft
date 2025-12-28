package soft.softfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.softfinal.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
