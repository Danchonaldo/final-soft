package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRequestDTO {
    private Long userId;
    private String specialization;
    private String cabinet;
    private String phone;
}
