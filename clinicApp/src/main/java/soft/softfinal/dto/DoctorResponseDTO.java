package soft.softfinal.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponseDTO {
    private Long id;
    private UserResponseDTO user;
    private String specialization;
    private String cabinet;
    private String phone;
}
