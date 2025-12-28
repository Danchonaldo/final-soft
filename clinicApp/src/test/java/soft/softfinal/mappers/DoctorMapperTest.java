package soft.softfinal.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import soft.softfinal.entity.Doctor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DoctorMapperTest {

    @Autowired
    private DoctorMapper doctorMapper;

    @Test
    void shouldMapEntityToResponseDto() {
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setSpecialization("Therapist");
        doctor.setCabinet("203");
        doctor.setPhone("+77009998877");

        var dto = doctorMapper.toResponseDTO(doctor);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Therapist", dto.getSpecialization());
        assertEquals("203", dto.getCabinet());
        assertEquals("+77009998877", dto.getPhone());
    }
}
