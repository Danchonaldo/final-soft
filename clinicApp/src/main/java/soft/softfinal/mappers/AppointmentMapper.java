package soft.softfinal.mappers;

import org.mapstruct.Mapper;
import soft.softfinal.dto.AppointmentRequestDTO;
import soft.softfinal.dto.AppointmentResponseDTO;
import soft.softfinal.entity.Appointment;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    Appointment toEntity(AppointmentRequestDTO dto);

    AppointmentResponseDTO toDto(Appointment appointment);

    default LocalDateTime map(String value) {
        return value == null ? null : LocalDateTime.parse(value);
    }

    default String map(LocalDateTime value) {
        return value == null ? null : value.toString();
    }
}


