package soft.softfinal.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import soft.softfinal.entity.MedicalRecord;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicalRecordMapperTest {

    @Autowired
    private MedicalRecordMapper medicalRecordMapper;

    @Test
    void shouldMapEntityToResponseDto() {
        MedicalRecord record = new MedicalRecord();
        record.setId(1L);
        record.setDiagnosis("Flu");
        record.setTreatment("Rest");
        record.setNotes("Drink water");

        var dto = medicalRecordMapper.toResponseDTO(record);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Flu", dto.getDiagnosis());
        assertEquals("Rest", dto.getTreatment());
        assertEquals("Drink water", dto.getNotes());
    }
}
