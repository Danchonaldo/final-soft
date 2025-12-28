package soft.softfinal.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecordResponseDTO {
    private Long id;
    private AppointmentResponseDTO appointment;
    private DoctorResponseDTO doctor;
    private PatientResponseDTO patient;
    private String diagnosis;
    private String treatment;
    private String notes;
    private String createdAt;
}
