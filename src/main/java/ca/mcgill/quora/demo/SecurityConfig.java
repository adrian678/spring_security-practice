package ca.mcgill.quora.demo;

import ca.mcgill.quora.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /* Note on component scan and Spring Application Context Hierarchies:
        SpringSecurityConfig is a parent of the WebConfiguration Context

     */

    @Autowired
    UserService userDetailsService;     //TODO should it be of type UserService or UserDetailsSevice

    @Bean
    public PasswordEncoder passwordEncoder(){ return NoOpPasswordEncoder.getInstance(); }
//    public PasswordEncoder passwordEncoder(){        return new BCryptPasswordEncoder();    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);    //TODO finish writing this to properly authenticate user
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasAnyRole("ADMIN")
                .antMatchers("/users").hasAnyRole("USER", "ADMIN")   //TODO change to permitAll? A user's public data should be visible, like in Reddit, imgur, quora
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
