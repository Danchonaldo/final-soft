package soft.softfinal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soft.softfinal.dto.MedicalRecordRequestDTO;
import soft.softfinal.entity.MedicalRecord;
import soft.softfinal.mappers.MedicalRecordMapper;
import soft.softfinal.repositories.MedicalRecordRepository;
import soft.softfinal.services.impl.MedicalRecordServiceImpl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceImplTest {

    @Mock
    private MedicalRecordRepository medicalRecordRepository;

    @Mock
    private MedicalRecordMapper medicalRecordMapper;

    @InjectMocks
    private MedicalRecordServiceImpl medicalRecordService;

    @Test
    void createMedicalRecord_savesEntity() {
        MedicalRecordRequestDTO req = new MedicalRecordRequestDTO();
        req.setAppointmentId(1L);
        req.setDoctorId(1L);
        req.setPatientId(1L);
        req.setDiagnosis("Pending");
        req.setTreatment("--");
        req.setNotes("Will be completed after appointment");
        req.setCreatedAt("2025-12-27");

        MedicalRecord entity = new MedicalRecord();

        when(medicalRecordMapper.toEntity(req)).thenReturn(entity);
        when(medicalRecordRepository.save(entity)).thenReturn(entity);

        medicalRecordService.create(req);

        verify(medicalRecordMapper, times(1)).toEntity(req);
        verify(medicalRecordRepository, times(1)).save(entity);
    }
}
