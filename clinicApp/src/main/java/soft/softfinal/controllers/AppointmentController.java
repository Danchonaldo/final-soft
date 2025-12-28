package soft.softfinal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import soft.softfinal.dto.AppointmentRequestDTO;
import soft.softfinal.dto.AppointmentResponseDTO;
import soft.softfinal.services.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_PATIENT') or hasAuthority('ROLE_ADMIN')")
    public AppointmentResponseDTO create(@RequestBody AppointmentRequestDTO request) {
        return appointmentService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<AppointmentResponseDTO> getAll() {
        return appointmentService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public AppointmentResponseDTO getById(@PathVariable Long id) {
        return appointmentService.getById(id);
    }

    @GetMapping("/doctor/{doctorId}")
    @PreAuthorize("hasAuthority('ROLE_DOCTOR') or hasAuthority('ROLE_ADMIN')")
    public List<AppointmentResponseDTO> getByDoctor(@PathVariable Long doctorId) {
        return appointmentService.getByDoctor(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    @PreAuthorize("hasAuthority('ROLE_PATIENT') or hasAuthority('ROLE_ADMIN')")
    public List<AppointmentResponseDTO> getByPatient(@PathVariable Long patientId) {
        return appointmentService.getByPatient(patientId);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}
