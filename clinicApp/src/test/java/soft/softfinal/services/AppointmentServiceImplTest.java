package soft.softfinal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soft.softfinal.dto.AppointmentRequestDTO;
import soft.softfinal.entity.Appointment;
import soft.softfinal.mappers.AppointmentMapper;
import soft.softfinal.repositories.AppointmentRepository;
import soft.softfinal.services.impl.AppointmentServiceImpl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceImplTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private AppointmentMapper appointmentMapper;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @Test
    void createAppointment_savesEntity() {
        AppointmentRequestDTO req = new AppointmentRequestDTO();
        req.setDoctorId(1L);
        req.setPatientId(1L);
        req.setAppointmentDateTime("2025-12-28 10:00");
        req.setStatus("SCHEDULED");
        req.setReason("General check-up");

        Appointment entity = new Appointment();

        when(appointmentMapper.toEntity(req)).thenReturn(entity);
        when(appointmentRepository.save(entity)).thenReturn(entity);

        appointmentService.create(req);

        verify(appointmentMapper, times(1)).toEntity(req);
        verify(appointmentRepository, times(1)).save(entity);
    }
}
