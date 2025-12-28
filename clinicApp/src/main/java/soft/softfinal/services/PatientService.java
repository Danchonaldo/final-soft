package soft.softfinal.services;

import soft.softfinal.dto.PatientRequestDTO;
import soft.softfinal.dto.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    PatientResponseDTO create(PatientRequestDTO request);
    List<PatientResponseDTO> getAll();
    PatientResponseDTO getById(Long id);
    void delete(Long id);
}
