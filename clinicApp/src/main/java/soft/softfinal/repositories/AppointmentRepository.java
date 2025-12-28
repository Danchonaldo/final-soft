package soft.softfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.softfinal.entity.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDoctor_Id(Long doctorId);
    List<Appointment> findAllByPatient_Id(Long patientId);
}
