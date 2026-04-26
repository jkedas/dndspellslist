package com.example.dndspellslist.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestClient;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }
		
	@Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder.build();
    }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(
	UserDetailsService userDetailsService,
	BCryptPasswordEncoder passwordEncoder) {
	
	DaoAuthenticationProvider authProvider =
	new DaoAuthenticationProvider(userDetailsService);
	
	authProvider.setPasswordEncoder(passwordEncoder);
	
	return authProvider;
	}
	

	@Bean
	public SecurityFilterChain securityFilterChain(
	        HttpSecurity http,
	        DaoAuthenticationProvider authProvider) throws Exception {
	
	    http
	        .authenticationProvider(authProvider)
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/", "/home", "/register", "/process_register", "/signup", "/spells", "/help", "/css/**", "/js/**").permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin(form -> form
	            .usernameParameter("email")
	            .defaultSuccessUrl("/", true)
	            .permitAll()
	        )
	        .logout(logout -> logout
	            .logoutSuccessUrl("/")
	        );
	
	    return http.build();
	}
}
