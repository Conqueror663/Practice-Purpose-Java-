//package com.Practice.Web.controller;
//
//import com.Practice.Web.model.Users;
////import com.Practice.Web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public Users register(@RequestBody Users users) {
//        return userService.register(users);
//    }
//
//   @PostMapping("/login")
//    public String login(@RequestBody Users users){
//        return userService.verify(users);
//   }
//}
