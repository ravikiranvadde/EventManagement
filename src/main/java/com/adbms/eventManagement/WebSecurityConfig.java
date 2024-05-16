package com.adbms.fleetXpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.adbms.fleetXpress.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    private UserDetailService userDetailsService;
	
//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authenticationProvider());
                
    }
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailService();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
		return daoAuthenticationProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/registration").permitAll()
			.antMatchers("/admin/**").hasAuthority("ADMIN")
			.antMatchers("/**").hasAnyAuthority("USER","ADMIN","DRIVER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll().defaultSuccessUrl("/home", true)
			.usernameParameter("username")
			.passwordParameter("password")
			.and().logout()
			.permitAll()
			.logoutSuccessUrl("/").invalidateHttpSession(true)
			.deleteCookies("JSESSIONID").and().exceptionHandling()
			.accessDeniedPage("/access-denied").and().csrf().disable();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
	
	}
	
