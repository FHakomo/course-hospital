package ua.com.kisit.coursehospital.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.kisit.coursehospital.service.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UsersService usersService;

    public WebSecurityConfig(UsersService usersService) {
        this.usersService = usersService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usersService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/registration", "/static/**", "/admin","/prescriptions").permitAll()
                        .requestMatchers("/patients","/prescribe", "/prescribetopatients", "/addToList", "/diagnosePatient", "/Diagnose").hasAuthority("ROLE_DOCTOR")
                        .requestMatchers("/patients","/prescribe", "/prescribetopatients", "/addToList").hasAuthority("ROLE_HELPER")
                        .requestMatchers( "/manager","/createNewCategory", "/CreateNewPrescription", "/UpdatePrescription", "/DeletePrescription").hasAuthority("ROLE_MANAGER")
                        .requestMatchers("/admin",  "/admin/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/")
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/403")
                )
                .authenticationProvider(authenticationProvider());

        return http.build();
    }

}
