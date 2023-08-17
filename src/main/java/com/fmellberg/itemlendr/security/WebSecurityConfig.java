package com.fmellberg.itemlendr.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomUserDetailService customUserDetailService;
    private final UnauthorizedHandler unauthorizedHandler;

    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .exceptionHandling(h -> h.authenticationEntryPoint(unauthorizedHandler))
                .securityMatcher("/**")
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers(mvcMatcherBuilder.pattern("/")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/auth/login")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/user/delete")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/user/create")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/user/update")).hasRole("ADMIN or hasRole('USER')")
                        .requestMatchers(mvcMatcherBuilder.pattern("/user/get/**")).hasRole("ADMIN or hasRole('USER')")
                        .requestMatchers(mvcMatcherBuilder.pattern("/user/getall")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/item/delete")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/item/create")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/item/update")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/item/get/**")).hasRole("ADMIN or hasRole('USER')")
                        .requestMatchers(mvcMatcherBuilder.pattern("/item/getall")).hasRole("ADMIN or hasRole('USER')")
                        .requestMatchers(mvcMatcherBuilder.pattern("/booking/delete")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/booking/create")).hasRole("ADMIN or hasRole('USER')")
                        .requestMatchers(mvcMatcherBuilder.pattern("/booking/update")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/booking/get/**")).hasRole("ADMIN or hasRole('USER')")
                        .requestMatchers(mvcMatcherBuilder.pattern("/booking/getAll")).hasRole("ADMIN")
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());
        return builder.build();
    }
}
