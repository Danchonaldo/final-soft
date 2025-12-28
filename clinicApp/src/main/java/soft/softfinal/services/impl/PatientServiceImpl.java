package soft.softfinal.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.softfinal.dto.PatientRequestDTO;
import soft.softfinal.dto.PatientResponseDTO;
import soft.softfinal.entity.Patient;
import soft.softfinal.mappers.PatientMapper;
import soft.softfinal.repositories.PatientRepository;
import soft.softfinal.services.PatientService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientResponseDTO create(PatientRequestDTO request) {
        Patient patient = patientMapper.toEntity(request);
        return patientMapper.toResponseDTO(patientRepository.save(patient));
    }

    @Override
    public List<PatientResponseDTO> getAll() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> dtos = new ArrayList<>();
        for (Patient p : patients) {
            dtos.add(patientMapper.toResponseDTO(p));
        }
        return dtos;
    }

    @Override
    public PatientResponseDTO getById(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        return (patient != null) ? patientMapper.toResponseDTO(patient) : null;
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
