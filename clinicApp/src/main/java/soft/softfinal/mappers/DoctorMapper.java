package soft.softfinal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import soft.softfinal.dto.DoctorRequestDTO;
import soft.softfinal.dto.DoctorResponseDTO;
import soft.softfinal.entity.Doctor;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface DoctorMapper {

    @Mapping(target = "user.id", source = "userId")
    Doctor toEntity(DoctorRequestDTO dto);

    DoctorResponseDTO toResponseDTO(Doctor entity);
}
