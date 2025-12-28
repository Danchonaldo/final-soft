package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MedicalRecordRequestDTO {
    private Long appointmentId;
    private Long doctorId;
    private Long patientId;
    private String diagnosis;
    private String treatment;
    private String notes;
    private String createdAt;
}
