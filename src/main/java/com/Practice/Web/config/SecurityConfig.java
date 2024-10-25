//package com.Practice.Web.config;
//
//
//import com.mysql.cj.protocol.AuthenticationProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cglib.proxy.NoOp;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
//import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private UserDetailsService userDetailsService;//it is a builtin class but we are making it for pracctice;
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//
//        // Allow access to the registration endpoint without authentication
//        httpSecurity.authorizeHttpRequests(request ->
//                request.requestMatchers("/register","/login").permitAll() // Allow unauthenticated access
//                        .anyRequest().authenticated() // Require authentication for all other requests
//        );
//
//        httpSecurity.formLogin(Customizer.withDefaults());
//        httpSecurity.httpBasic(Customizer.withDefaults());
//        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return httpSecurity.build();
//    }
//
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////
////        httpSecurity.csrf(AbstractHttpConfigurer::disable);
////        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////        httpSecurity.formLogin(Customizer.withDefaults());
////        httpSecurity.httpBasic(Customizer.withDefaults());
////        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////        return httpSecurity.build();
////    }
//
//
////
////    @Bean
////    public UserDetailsService userDetailsService(){
////
////        UserDetails user1 = User
////                .withDefaultPasswordEncoder()
////                .username("usman")
////                .password("abc")
////                .roles("admin")
////                .build();
////
////    return new InMemoryUserDetailsManager(user1);
////    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//    return configuration.getAuthenticationManager();
//    }
//
//
//}
