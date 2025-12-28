package soft.softfinal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import soft.softfinal.dto.MedicalRecordRequestDTO;
import soft.softfinal.dto.MedicalRecordResponseDTO;
import soft.softfinal.services.MedicalRecordService;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_DOCTOR') or hasAuthority('ROLE_ADMIN')")
    public MedicalRecordResponseDTO create(@RequestBody MedicalRecordRequestDTO request) {
        return medicalRecordService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<MedicalRecordResponseDTO> getAll() {
        return medicalRecordService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public MedicalRecordResponseDTO getById(@PathVariable Long id) {
        return medicalRecordService.getById(id);
    }

    @GetMapping("/doctor/{doctorId}")
    @PreAuthorize("hasAuthority('ROLE_DOCTOR') or hasAuthority('ROLE_ADMIN')")
    public List<MedicalRecordResponseDTO> getByDoctor(@PathVariable Long doctorId) {
        return medicalRecordService.getByDoctor(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    @PreAuthorize("hasAuthority('ROLE_PATIENT') or hasAuthority('ROLE_ADMIN')")
    public List<MedicalRecordResponseDTO> getByPatient(@PathVariable Long patientId) {
        return medicalRecordService.getByPatient(patientId);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        medicalRecordService.delete(id);
    }
}
