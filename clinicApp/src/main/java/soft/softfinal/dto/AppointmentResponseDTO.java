package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentResponseDTO {
    private Long id;
    private DoctorResponseDTO doctor;
    private PatientResponseDTO patient;
    private String appointmentDateTime;
    private String status;
    private String reason;
}
