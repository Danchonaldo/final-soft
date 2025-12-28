package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
