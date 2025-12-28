package soft.softfinal.services;

import soft.softfinal.dto.AppointmentRequestDTO;
import soft.softfinal.dto.AppointmentResponseDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentResponseDTO create(AppointmentRequestDTO request);
    List<AppointmentResponseDTO> getAll();
    AppointmentResponseDTO getById(Long id);
    List<AppointmentResponseDTO> getByDoctor(Long doctorId);
    List<AppointmentResponseDTO> getByPatient(Long patientId);
    void delete(Long id);
}
