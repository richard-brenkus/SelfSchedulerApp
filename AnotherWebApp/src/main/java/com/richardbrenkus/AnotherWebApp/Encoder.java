package com.richardbrenkus.AnotherWebApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Encoder extends BCryptPasswordEncoder{
 
	@Bean
	@Primary
   public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A);
   }
	
//	@Bean
//	public static PasswordEncoder passwordEncoder() {
//	      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}


//  
 }