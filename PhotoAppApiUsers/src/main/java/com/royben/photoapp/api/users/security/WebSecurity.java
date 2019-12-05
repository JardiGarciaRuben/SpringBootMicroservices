package com.royben.photoapp.api.users.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.royben.photoapp.api.users.service.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	Environment env;

	@Autowired
	UsersService usersService;

	@Autowired
	BCryptPasswordEncoder vCryptPasswordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// disable security
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip")).and()
				.addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
		super.configure(http);
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
			AuthenticationFilter authenticationFilter = new AuthenticationFilter(usersService,env,authenticationManager());
			authenticationFilter.setFilterProcessesUrl(env.getProperty("login.url.path"));
			return authenticationFilter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usersService).passwordEncoder(vCryptPasswordEncoder);
	}
}
