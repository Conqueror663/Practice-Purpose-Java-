//package com.Practice.Web.service;
//
//
//import com.Practice.Web.model.Users;
//import com.Practice.Web.repositary.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//
//    @Autowired
//    private JWTService jwtService;
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
//public Users register(Users users) {
//    users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//    return userRepo.save(users);
//}
//
//    public String verify(Users users) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
//
//            if (authentication.isAuthenticated()) {
//                return jwtService.generateToken(users.getUsername()); // Return token on success
//            } else {
//                return "Authentication Failed"; // Handle failure more explicitly
//            }
//        } catch (Exception e) {
//            // Catch exceptions during authentication and log them or return a proper error message
//            System.out.println("Authentication Error: " + e.getMessage());
//            return "Authentication Error: " + e.getMessage();
//        }
//    }
//
//}
