package soft.softfinal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import soft.softfinal.dto.PatientRequestDTO;
import soft.softfinal.dto.PatientResponseDTO;
import soft.softfinal.services.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public PatientResponseDTO create(@RequestBody PatientRequestDTO request) {
        return patientService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<PatientResponseDTO> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public PatientResponseDTO getById(@PathVariable Long id) {
        return patientService.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }
}
