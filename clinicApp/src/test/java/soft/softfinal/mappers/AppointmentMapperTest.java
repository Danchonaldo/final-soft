package soft.softfinal.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import soft.softfinal.dto.AppointmentRequestDTO;
import soft.softfinal.dto.AppointmentResponseDTO;
import soft.softfinal.entity.Appointment;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentMapperTest {

    private final AppointmentMapper mapper =
            Mappers.getMapper(AppointmentMapper.class);

    @Test
    void shouldMapRequestDtoToEntity() {
        AppointmentRequestDTO dto = new AppointmentRequestDTO();
        dto.setReason("Headache");
        dto.setAppointmentDateTime("2025-12-30T10:00");

        Appointment appointment = mapper.toEntity(dto);

        assertNotNull(appointment);
        assertEquals("Headache", appointment.getReason());
        assertEquals(
                "2025-12-30T10:00",
                appointment.getAppointmentDateTime()
        );
    }

    @Test
    void shouldMapEntityToResponseDto() {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        appointment.setReason("Checkup");
        appointment.setAppointmentDateTime("2025-12-30T10:00");

        AppointmentResponseDTO dto = mapper.toDto(appointment);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Checkup", dto.getReason());
        assertEquals(
                "2025-12-30T10:00",
                dto.getAppointmentDateTime()
        );
    }
}
