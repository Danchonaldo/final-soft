package soft.softfinal.mappers;
import soft.softfinal.entity.User;
import org.mapstruct.Mapper;
import soft.softfinal.dto.UserRequestDTO;
import soft.softfinal.dto.UserResponseDTO;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class})
public interface UserMapper {
    User toEntity(UserRequestDTO dto);
    UserResponseDTO toResponseDTO(User entity);
}
