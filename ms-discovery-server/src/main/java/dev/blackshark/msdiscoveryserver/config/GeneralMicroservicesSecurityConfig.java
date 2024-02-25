package dev.blackshark.msdiscoveryserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  @EnableMethodSecurity
public class GeneralMicroservicesSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf()
            .ignoringRequestMatchers("/eureka/**")
            .and()
            .authorizeRequests()

            //.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
            //.antMatchers("/admin/**").hasAnyRole("ADMIN")
            //.antMatchers("/user/**").hasAnyRole("USER", "ADMIN")

            .requestMatchers("/login/**").anonymous()

            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic(Customizer.withDefaults())
        //.and()
        //.sessionManagement()
        //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
        return http.build();
    }
}
