package br.com.joaovictor.medicalconsult.config;



import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpHeaderSecurityFilter http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/usuarios").hasAnyRole("ADMIN", "SECRETARIO")
                        .requestMatchers(HttpMethod.GET, "/usuarios").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios").hasAnyRole("ADMIN", "SECRETARIO")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("JOAO").password(passwordEncoder.encode("12345")).roles("ADMIN")
                .and()
                .withUser("CALVIN").password(passwordEncoder.encode("98765")).roles("PACIENTE")
                .and()
                .withUser("Fernanda").password(passwordEncoder.encode("121212")).roles("SECRETARIA");

    }
    private static final String[] PUBLIC_MATCHES = {
            "/h2-console/",
            "/swagger-ui/",
            "/v3/api-docs/"
    };

    private static final String[] PUBLIC_MATCHES_GET = {
            "/user/",
            "/consult/"
    };

    private static final String[] PUBLIC_MATCHES_POST = {
            "/user/",
            "/consult/"
    };

    private static final String[] PUBLIC_MATCHES_PUT = {
            "/user/",
            "/consult/"
    };

    private static final String[] PUBLIC_MATCHES_DELETE = {
            "/user/",
            "/consult/"
    };
}
