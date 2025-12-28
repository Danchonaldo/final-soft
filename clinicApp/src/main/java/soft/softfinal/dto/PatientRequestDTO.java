package soft.softfinal.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {
    private Long userId;
    private String iin;
    private String birthDate;
    private String phone;
}
