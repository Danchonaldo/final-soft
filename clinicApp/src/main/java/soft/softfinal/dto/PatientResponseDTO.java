package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResponseDTO {
    private Long id;
    private UserResponseDTO user;
    private String iin;
    private String birthDate;
    private String phone;
}
