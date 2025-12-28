package soft.softfinal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import soft.softfinal.dto.UserRequestDTO;
import soft.softfinal.dto.UserResponseDTO;
import soft.softfinal.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody UserRequestDTO request) {
        return userService.register(request);
    }

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public Map<String, Object> me(Authentication authentication) {
        Map<String, Object> res = new HashMap<>();
        res.put("email", authentication.getName());
        res.put("roles", authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));
        return res;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserResponseDTO> getAll() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}/profile")
    @PreAuthorize("isAuthenticated()")
    public UserResponseDTO updateProfile(@PathVariable Long id, @RequestParam String fullName) {
        return userService.updateProfile(id, fullName);
    }

    @PutMapping("/{id}/change-password")
    @PreAuthorize("isAuthenticated()")
    public String changePassword(@PathVariable Long id,
                                 @RequestParam String oldPass,
                                 @RequestParam String newPass) {
        boolean success = userService.changePassword(id, oldPass, newPass);
        return success ? "Пароль успешно изменен" : "Ошибка: старый пароль неверный";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
