package com.WSource.apiServer.controller;


import com.WSource.apiServer.entity.User;
import com.WSource.apiServer.repository.UserRepository;
import com.WSource.apiServer.service.JwtUserDetailService;
import com.WSource.apiServer.service.UserService;
import com.WSource.apiServer.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="api/v1/user")
public class UserController {

    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(path="/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        String token = null;
        try {
            token = userService.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    @PostMapping(path="/register") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody User user) {
        String token = null;
        try {
            token = userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}