package soft.softfinal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soft.softfinal.dto.PatientRequestDTO;
import soft.softfinal.entity.Patient;
import soft.softfinal.mappers.PatientMapper;
import soft.softfinal.repositories.PatientRepository;
import soft.softfinal.services.impl.PatientServiceImpl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    void createPatient_savesEntity() {
        PatientRequestDTO req = new PatientRequestDTO();
        req.setUserId(3L);
        req.setIin("111111111111");
        req.setBirthDate("1999-12-31");
        req.setPhone("+7 700 000 00 02");

        Patient entity = new Patient();

        when(patientMapper.toEntity(req)).thenReturn(entity);
        when(patientRepository.save(entity)).thenReturn(entity);

        patientService.create(req);

        verify(patientMapper, times(1)).toEntity(req);
        verify(patientRepository, times(1)).save(entity);
    }
}
