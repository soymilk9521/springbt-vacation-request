package com.vacation.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import com.vacation.app.service.CustomUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }
	 
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/scripts/**", "/img/**").permitAll();
		http.authorizeRequests().antMatchers("/apply").fullyAuthenticated(); // open login page when session is changed 
		http.authorizeRequests().anyRequest().authenticated()
        .and().formLogin().loginPage("/login")
        // 设置默认登录成功跳转页面
        .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
        .and()
        // 开启cookie保存用户数据
        .rememberMe()
        // .useSecureCookie(true) // only https effect
        // 设置cookie有效期
        .tokenValiditySeconds(60 * 60 * 24 * 7)
        .tokenRepository(new InMemoryTokenRepositoryImpl()) //check cookie
        // 设置cookie的私钥
        // .key("c295bWlsazk1MjE=") // base64 encoded string
        .and()
        .logout()
        // 默认注销行为为logout，可以通过下面的方式来修改
        // .logoutUrl("/logoout")
        // 设置注销成功后跳转页面，默认是跳转到登录页面
        //.logoutSuccessUrl("")
        .permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");

	}
}
