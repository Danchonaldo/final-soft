package soft.softfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResponseDTO {
    private Long id;
    private UserResponseDTO user;
    private String specialization;
    private String cabinet;
    private String phone;
}
