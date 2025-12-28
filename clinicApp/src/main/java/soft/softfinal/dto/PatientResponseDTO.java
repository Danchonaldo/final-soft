package soft.softfinal.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDTO {
    private Long id;
    private UserResponseDTO user;
    private String iin;
    private String birthDate;
    private String phone;
}
