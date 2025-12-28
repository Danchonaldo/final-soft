package soft.softfinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_doctors")
@Getter
@Setter
public class Doctor extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "cabinet")
    private String cabinet;

    @Column(name = "phone")
    private String phone;
}
