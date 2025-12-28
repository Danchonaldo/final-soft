package soft.softfinal.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequestDTO {
    private Long userId;
    private String specialization;
    private String cabinet;
    private String phone;
}
