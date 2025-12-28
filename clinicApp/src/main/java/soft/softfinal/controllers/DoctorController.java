package soft.softfinal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import soft.softfinal.dto.DoctorRequestDTO;
import soft.softfinal.dto.DoctorResponseDTO;
import soft.softfinal.services.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public DoctorResponseDTO create(@RequestBody DoctorRequestDTO request) {
        return doctorService.create(request);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<DoctorResponseDTO> getAll() {
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public DoctorResponseDTO getById(@PathVariable Long id) {
        return doctorService.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        doctorService.delete(id);
    }
}
