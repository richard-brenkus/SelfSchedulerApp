package com.richardbrenkus.AnotherWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Autowired
	Encoder encode;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(encode.passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	//	auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("patrick"));
	}

	
// ACTIVATE THIS BLOCK TO ENABLE SECURITY: 	
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.antMatchers("/", "/home").permitAll()
					.antMatchers("/admin/**").hasAuthority("ADMIN")
					.antMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")
					.anyRequest().authenticated()
					.and()
					.csrf().disable()
				.formLogin()
					.permitAll()

					.and()
				.logout() //.invalidateHttpSession(true).clearAuthentication(true)
					.permitAll()
					.and()
					.exceptionHandling().accessDeniedPage("/403");
				}
	 

	/* ACTIVATE THIS BLOCK TO DISABLE SECURITY:
	 * 
	 *
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.anyRequest().permitAll()
					.and()
					.csrf().disable()
				.formLogin()
					.permitAll()

					.and()
				.logout() //.invalidateHttpSession(true).clearAuthentication(true)
					.permitAll()
					.and()
					.exceptionHandling().accessDeniedPage("/403");
				}
	*/
}
