package soft.softfinal.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.softfinal.dto.DoctorRequestDTO;
import soft.softfinal.dto.DoctorResponseDTO;
import soft.softfinal.entity.Doctor;
import soft.softfinal.mappers.DoctorMapper;
import soft.softfinal.repositories.DoctorRepository;
import soft.softfinal.services.DoctorService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponseDTO create(DoctorRequestDTO request) {
        Doctor doctor = doctorMapper.toEntity(request);
        return doctorMapper.toResponseDTO(doctorRepository.save(doctor));
    }

    @Override
    public List<DoctorResponseDTO> getAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorResponseDTO> dtos = new ArrayList<>();
        for (Doctor d : doctors) {
            dtos.add(doctorMapper.toResponseDTO(d));
        }
        return dtos;
    }

    @Override
    public DoctorResponseDTO getById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        return (doctor != null) ? doctorMapper.toResponseDTO(doctor) : null;
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
