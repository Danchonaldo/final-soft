package soft.softfinal.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.softfinal.dto.AppointmentRequestDTO;
import soft.softfinal.dto.AppointmentResponseDTO;
import soft.softfinal.entity.Appointment;
import soft.softfinal.mappers.AppointmentMapper;
import soft.softfinal.repositories.AppointmentRepository;
import soft.softfinal.services.AppointmentService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public AppointmentResponseDTO create(AppointmentRequestDTO request) {
        Appointment appointment = appointmentMapper.toEntity(request);
        return appointmentMapper.toDto(appointmentRepository.save(appointment));
    }

    @Override
    public List<AppointmentResponseDTO> getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentResponseDTO> dtos = new ArrayList<>();
        for (Appointment a : appointments) {
            dtos.add(appointmentMapper.toDto(a));
        }
        return dtos;
    }

    @Override
    public AppointmentResponseDTO getById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        return (appointment != null) ? appointmentMapper.toDto(appointment) : null;
    }

    @Override
    public List<AppointmentResponseDTO> getByDoctor(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findAllByDoctor_Id(doctorId);
        List<AppointmentResponseDTO> dtos = new ArrayList<>();
        for (Appointment a : appointments) {
            dtos.add(appointmentMapper.toDto(a));
        }
        return dtos;
    }

    @Override
    public List<AppointmentResponseDTO> getByPatient(Long patientId) {
        List<Appointment> appointments = appointmentRepository.findAllByPatient_Id(patientId);
        List<AppointmentResponseDTO> dtos = new ArrayList<>();
        for (Appointment a : appointments) {
            dtos.add(appointmentMapper.toDto(a));
        }
        return dtos;
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }
}
