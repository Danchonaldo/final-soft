package soft.softfinal.services;

import soft.softfinal.dto.MedicalRecordRequestDTO;
import soft.softfinal.dto.MedicalRecordResponseDTO;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordResponseDTO create(MedicalRecordRequestDTO request);
    List<MedicalRecordResponseDTO> getAll();
    MedicalRecordResponseDTO getById(Long id);
    List<MedicalRecordResponseDTO> getByDoctor(Long doctorId);
    List<MedicalRecordResponseDTO> getByPatient(Long patientId);
    void delete(Long id);
}
