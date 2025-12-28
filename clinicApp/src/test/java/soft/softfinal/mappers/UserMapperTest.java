package soft.softfinal.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import soft.softfinal.dto.UserRequestDTO;
import soft.softfinal.dto.UserResponseDTO;
import soft.softfinal.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    void shouldMapRequestDtoToEntity() {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setEmail("test@clinic.com");
        dto.setFullName("Test User");

        User user = mapper.toEntity(dto);

        assertNotNull(user);
        assertEquals("test@clinic.com", user.getEmail());
        assertEquals("Test User", user.getFullName());
    }

    @Test
    void shouldMapEntityToResponseDto() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@clinic.com");
        user.setFullName("Test User");

        UserResponseDTO dto = mapper.toResponseDTO(user);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("test@clinic.com", dto.getEmail());
        assertEquals("Test User", dto.getFullName());
    }
}
