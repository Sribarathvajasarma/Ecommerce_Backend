package com.springboot.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.demo.filter.CustomAuthenticationFilter;
import com.springboot.demo.filter.CustomAuthorizationFilter;

@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
 
    private final UserDetailsService userDetailService;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    
	

	public SecurityConfig(UserDetailsService userDetailService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		super();
		this.userDetailService = userDetailService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bcryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/api/login/**", "/api/token/refresh/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/user").permitAll();

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/product/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/product/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/purchase/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/purchase/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/payment/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/payment/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/delivery/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/delivery/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/product/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/product/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/user/save/**").hasAnyAuthority("ROLE_SELLER");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
		http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
		
	}
	
	
	
	
}
