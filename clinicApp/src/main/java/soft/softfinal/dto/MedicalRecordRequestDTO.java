package soft.softfinal.dto;

import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecordRequestDTO {
    private Long appointmentId;
    private Long doctorId;
    private Long patientId;
    private String diagnosis;
    private String treatment;
    private String notes;
    private String createdAt;
}
