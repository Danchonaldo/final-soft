package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
    private Long userId;
    private String iin;
    private String birthDate;
    private String phone;
}
