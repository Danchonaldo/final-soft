package soft.softfinal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soft.softfinal.dto.DoctorRequestDTO;
import soft.softfinal.entity.Doctor;
import soft.softfinal.mappers.DoctorMapper;
import soft.softfinal.repositories.DoctorRepository;
import soft.softfinal.services.impl.DoctorServiceImpl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private DoctorMapper doctorMapper;

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @Test
    void createDoctor_savesEntity() {
        DoctorRequestDTO req = new DoctorRequestDTO();
        req.setUserId(2L);
        req.setSpecialization("Therapist");
        req.setCabinet("101");
        req.setPhone("+7 700 000 00 01");

        Doctor entity = new Doctor();

        when(doctorMapper.toEntity(req)).thenReturn(entity);
        when(doctorRepository.save(entity)).thenReturn(entity);

        doctorService.create(req);

        verify(doctorMapper, times(1)).toEntity(req);
        verify(doctorRepository, times(1)).save(entity);
    }
}
