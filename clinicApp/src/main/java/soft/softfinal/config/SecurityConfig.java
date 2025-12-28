package soft.softfinal.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.exceptionHandling(exception -> exception
                .defaultAuthenticationEntryPointFor(
                        (request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.setContentType("application/json");
                            response.getWriter().write("{\"error\":\"Unauthorized\"}");
                        },
                        request -> request.getRequestURI() != null
                                && request.getRequestURI().startsWith("/api/")
                )
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    if (request.getRequestURI() != null && request.getRequestURI().startsWith("/api/")) {
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        response.setContentType("application/json");
                        response.getWriter().write("{\"error\":\"Forbidden\"}");
                    } else {
                        response.sendRedirect("/login?accessDenied");
                    }
                })
        );

        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(
                        "/", "/login", "/register",
                        "/api/users/register",
                        "/css/**", "/js/**", "/images/**"
                ).permitAll()

                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/api/doctors/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/api/patients/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/users").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasAuthority("ROLE_ADMIN")

                .requestMatchers("/doctor-panel/**").hasAuthority("ROLE_DOCTOR")
                .requestMatchers("/api/appointments/doctor/**").hasAuthority("ROLE_DOCTOR")
                .requestMatchers("/api/medical-records/**").hasAuthority("ROLE_DOCTOR")

                .requestMatchers("/patient-panel/**").hasAuthority("ROLE_PATIENT")
                .requestMatchers("/api/appointments/patient/**").hasAuthority("ROLE_PATIENT")

                .requestMatchers("/profile").authenticated()
                .requestMatchers("/api/users/me").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/users/*/profile").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/users/*/change-password").authenticated()

                .anyRequest().authenticated()
        );

        http.formLogin(login -> login
                .loginPage("/login")
                .loginProcessingUrl("/entering")
                .defaultSuccessUrl("/profile", true)
                .failureUrl("/login?error")
                .usernameParameter("user_email")
                .passwordParameter("user_password")
        );

        http.logout(logout -> logout
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
        );

        return http.build();
    }
}
