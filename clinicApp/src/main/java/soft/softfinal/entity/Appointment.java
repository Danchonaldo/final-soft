package soft.softfinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_appointments")
@Getter
@Setter
public class Appointment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "appointment_datetime", nullable = false)
    private String appointmentDateTime;

    @Column(name = "status", nullable = false)
    private String status; // SCHEDULED, COMPLETED, CANCELED

    @Column(name = "reason")
    private String reason;
}
