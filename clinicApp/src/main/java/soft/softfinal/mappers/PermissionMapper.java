package soft.softfinal.mappers;

import org.mapstruct.Mapper;
import soft.softfinal.dto.PermissionRequestDTO;
import soft.softfinal.dto.PermissionResponseDTO;
import soft.softfinal.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toEntity(PermissionRequestDTO dto);
    PermissionResponseDTO toResponseDTO(Permission entity);
}
