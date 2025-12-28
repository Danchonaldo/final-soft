package soft.softfinal.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequestDTO {
    private Long doctorId;
    private Long patientId;
    private String appointmentDateTime;
    private String status;
    private String reason;
}
