package com.icheck.backend.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.icheck.backend.util.JwtUtil;

@Component
public class JwtRequestFilter extends BasicAuthenticationFilter {

	private JwtUtil jwtUtil;

	public JwtRequestFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		// Lấy ra JWT token, parse token lấy ra userId, username và các thông tin cần
		// thiết mà trước đó lúc gen token đã put data vào token
		// Nếu parse được username, user id => tạo ra
		// UsernamePasswordAuthenticationToken và nhét vào context

		String username = null;
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}

//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
//            UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
//            if (jwtUtil.validateToken(jwt, userDetails)){
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }

		filterChain.doFilter(request, response);
	}
}
