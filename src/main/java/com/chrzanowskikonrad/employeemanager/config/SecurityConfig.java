//package com.chrzanowskikonrad.employeemanager.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//        corsConfiguration.setAllowedHeaders(Arrays.asList(
//                "Origins",
//                "Access-Control-Allow-Origins",
//                "Content-Type",
//                "Accept",
//                "Origin, Accept",
//                "X-Requested-With",
//                "Access-Control-Request-Method",
//                "Access-Control-Request-Headers"));
//        corsConfiguration.setExposedHeaders(Arrays.asList(
//                "Origins",
//                "Content-Type",
//                "Accept",
//                "Authorization",
//                "Access-Control-Allow-Origins",
//                "Access-Control-Allow-Credentials"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
//}
