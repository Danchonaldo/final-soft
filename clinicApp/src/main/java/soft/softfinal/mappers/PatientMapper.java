package soft.softfinal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import soft.softfinal.dto.PatientRequestDTO;
import soft.softfinal.dto.PatientResponseDTO;
import soft.softfinal.entity.Patient;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PatientMapper {

    @Mapping(target = "user.id", source = "userId")
    Patient toEntity(PatientRequestDTO dto);

    PatientResponseDTO toResponseDTO(Patient entity);
}
