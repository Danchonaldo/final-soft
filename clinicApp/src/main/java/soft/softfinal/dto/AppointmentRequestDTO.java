package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentRequestDTO {
    private Long doctorId;
    private Long patientId;
    private String appointmentDateTime;
    private String status;
    private String reason;
}
