package pl.loginblocked.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity // uaktywaniamy mechanizm security ktory opieral sie o
// konfiguracje przygotowana w ponizszej klasie
public class MyWebSecurity extends WebSecurityConfigurerAdapter {

	private MyUserDetailsService myUserDetailsService;
	@Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

	public MyWebSecurity(MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}

	// w tej metodzie definiujemy uzytkownikow, hasla oraz role
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		// in memory
		/*
		 * auth .inMemoryAuthentication()
		 * .withUser("user").password("1234").roles("USER") .and()
		 * .withUser("admin").password("1234").roles("USER", "ADMIN") .and()
		 * .withUser("super").password("1234").roles("USER", "ADMIN", "SUPER");
		 */
		auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	public SessionRegistry sessionRegistry() {
	    return new SessionRegistryImpl();
	}
	
	@Bean
	public static ServletListenerRegistrationBean httpSessionEventPublisher() {
	    return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
	}
	
	private static final String[] PUBLIC_MATCHERS = { "/css/**", "/js/**", "/fonts/**", "/img/**", "/vendor/**","/pdf/**",
			"/webjars/**", "/rest/**","/user/rememberPassword**","/user/createNewPassword**","/user/accountActivation**","/user/registrationConfirm**"};
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers(PUBLIC_MATCHERS);
	}

	// okresli nam kto moze gdzie wchodzic oraz okresli gdzie jest
	// formularz logowania, jak sie wylogowac oraz inne tematy z tym zwiazane
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
		.authorizeRequests()
		.anyRequest().permitAll();}*/
		
		http
		 .authorizeRequests()
			.antMatchers("/user/create").hasAnyRole("SUPER")
			.antMatchers("/user/**").hasAnyRole("ADMIN","SUPER")
			.antMatchers("publications/**").hasAnyRole("ADMIN","SUPER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.loginProcessingUrl("/app-login")
				.usernameParameter("username") 
				.passwordParameter("password")
				.defaultSuccessUrl("/home", true) 
				.failureUrl("/login?error")
				.failureHandler(authenticationFailureHandler)
				.and()
				.logout()
	            .logoutUrl("/app-logout")
	            	.clearAuthentication(true)
	                .logoutSuccessUrl("/login")
	                .permitAll().
	                and().exceptionHandling() 
	       		 .accessDeniedHandler(accessDeniedHandler())
	    		 .and().httpBasic();
		http
		  .sessionManagement()
		  .invalidSessionUrl("/login")
		  .maximumSessions(1).sessionRegistry(sessionRegistry()).expiredUrl("/login");	
	}

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
					AccessDeniedException e) throws IOException, ServletException {
				httpServletResponse.sendRedirect("/cites5/accessDenied");

			}
		};
	}
}
