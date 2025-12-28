package soft.softfinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_patients")
@Getter
@Setter
public class Patient extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "iin", unique = true)
    private String iin;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "phone")
    private String phone;
}
