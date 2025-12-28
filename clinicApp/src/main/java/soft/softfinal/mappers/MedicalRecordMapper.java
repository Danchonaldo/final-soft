package soft.softfinal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import soft.softfinal.dto.MedicalRecordRequestDTO;
import soft.softfinal.dto.MedicalRecordResponseDTO;
import soft.softfinal.entity.MedicalRecord;

@Mapper(componentModel = "spring", uses = {AppointmentMapper.class, DoctorMapper.class, PatientMapper.class})
public interface MedicalRecordMapper {

    @Mapping(target = "appointment.id", source = "appointmentId")
    @Mapping(target = "doctor.id", source = "doctorId")
    @Mapping(target = "patient.id", source = "patientId")
    MedicalRecord toEntity(MedicalRecordRequestDTO dto);

    MedicalRecordResponseDTO toResponseDTO(MedicalRecord entity);
}
