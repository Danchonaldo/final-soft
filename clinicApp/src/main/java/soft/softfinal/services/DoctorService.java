package soft.softfinal.services;

import soft.softfinal.dto.DoctorRequestDTO;
import soft.softfinal.dto.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {
    DoctorResponseDTO create(DoctorRequestDTO request);
    List<DoctorResponseDTO> getAll();
    DoctorResponseDTO getById(Long id);
    void delete(Long id);
}
