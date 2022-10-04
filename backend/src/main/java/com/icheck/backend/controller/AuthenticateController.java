package com.icheck.backend.controller;

import com.icheck.backend.request.AuthenticateRequest;
import com.icheck.backend.response.AuthenticateResponse;
import com.icheck.backend.security.MyUserDetailService;
import com.icheck.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private JwtUtil jwtTokenUntil;

    @GetMapping("/hello")
    public String sayHello(){
        return "Welcome to Spring Security";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
        System.out.println(authenticateRequest);
        try {
        	Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
//        	Từ authentication => get ra được đối tượng user detail mà đã load từ DB => Get được id, username, => Nhét id và username vào claim => gen ra token
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticateRequest.getUsername());
        System.out.println(userDetails);
        String jwt = jwtTokenUntil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }

}
