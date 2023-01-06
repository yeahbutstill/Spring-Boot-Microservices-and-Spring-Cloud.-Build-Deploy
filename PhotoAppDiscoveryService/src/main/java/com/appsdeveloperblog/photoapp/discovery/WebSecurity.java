package com.appsdeveloperblog.photoapp.discovery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity { //extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//                 .csrf()
//                 .disable()
//                 .authorizeRequests()
//                 .anyRequest().authenticated()
//                 .and()
//                 .httpBasic();
//     }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
 
}
