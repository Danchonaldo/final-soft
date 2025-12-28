package soft.softfinal.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.softfinal.dto.MedicalRecordRequestDTO;
import soft.softfinal.dto.MedicalRecordResponseDTO;
import soft.softfinal.entity.MedicalRecord;
import soft.softfinal.mappers.MedicalRecordMapper;
import soft.softfinal.repositories.MedicalRecordRepository;
import soft.softfinal.services.MedicalRecordService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalRecordMapper medicalRecordMapper;

    @Override
    public MedicalRecordResponseDTO create(MedicalRecordRequestDTO request) {
        MedicalRecord record = medicalRecordMapper.toEntity(request);
        return medicalRecordMapper.toResponseDTO(medicalRecordRepository.save(record));
    }

    @Override
    public List<MedicalRecordResponseDTO> getAll() {
        List<MedicalRecord> records = medicalRecordRepository.findAll();
        List<MedicalRecordResponseDTO> dtos = new ArrayList<>();
        for (MedicalRecord r : records) {
            dtos.add(medicalRecordMapper.toResponseDTO(r));
        }
        return dtos;
    }

    @Override
    public MedicalRecordResponseDTO getById(Long id) {
        MedicalRecord record = medicalRecordRepository.findById(id).orElse(null);
        return (record != null) ? medicalRecordMapper.toResponseDTO(record) : null;
    }

    @Override
    public List<MedicalRecordResponseDTO> getByDoctor(Long doctorId) {
        List<MedicalRecord> records = medicalRecordRepository.findAllByDoctor_Id(doctorId);
        List<MedicalRecordResponseDTO> dtos = new ArrayList<>();
        for (MedicalRecord r : records) {
            dtos.add(medicalRecordMapper.toResponseDTO(r));
        }
        return dtos;
    }

    @Override
    public List<MedicalRecordResponseDTO> getByPatient(Long patientId) {
        List<MedicalRecord> records = medicalRecordRepository.findAllByPatient_Id(patientId);
        List<MedicalRecordResponseDTO> dtos = new ArrayList<>();
        for (MedicalRecord r : records) {
            dtos.add(medicalRecordMapper.toResponseDTO(r));
        }
        return dtos;
    }

    @Override
    public void delete(Long id) {
        medicalRecordRepository.deleteById(id);
    }
}
