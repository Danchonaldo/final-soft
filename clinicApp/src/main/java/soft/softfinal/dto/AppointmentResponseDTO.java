package soft.softfinal.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponseDTO {
    private Long id;
    private DoctorResponseDTO doctor;
    private PatientResponseDTO patient;
    private String appointmentDateTime;
    private String status;
    private String reason;
}
