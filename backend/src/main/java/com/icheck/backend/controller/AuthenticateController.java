package com.icheck.backend.controller;

import com.icheck.backend.converter.AdminConverter;
import com.icheck.backend.exception.ApiException;
import com.icheck.backend.exception.ErrorMessage;
import com.icheck.backend.request.authen_request.AuthenticateRequest;
import com.icheck.backend.response.authen_response.AuthenticateResponse;
import com.icheck.backend.security.AdminAccount;
import com.icheck.backend.DAO.AdminService;
import com.icheck.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUntil;

    @GetMapping("/hello")
    public String sayHello(){
        return "Welcome to Spring Security";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
        Authentication authenticate;

        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
            //Từ authentication => get ra được đối tượng user detail mà đã load từ DB => Get được id, username, => Nhét id và username vào claim => gen ra token
        }catch(BadCredentialsException e){
            throw new ApiException(ErrorMessage.INCORRECT_LOGIN);
        }

        String jwt = jwtTokenUntil.generateToken((AdminAccount) authenticate.getPrincipal());
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }

}
