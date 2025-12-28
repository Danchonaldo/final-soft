package soft.softfinal.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import soft.softfinal.entity.Patient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientMapperTest {

    @Autowired
    private PatientMapper patientMapper;

    @Test
    void shouldMapEntityToResponseDto() {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setPhone("+77007778899");

        var dto = patientMapper.toResponseDTO(patient);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("+77007778899", dto.getPhone());
    }
}
