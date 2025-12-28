package soft.softfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.softfinal.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findAllByPatient_Id(Long patientId);
    List<MedicalRecord> findAllByDoctor_Id(Long doctorId);
}
