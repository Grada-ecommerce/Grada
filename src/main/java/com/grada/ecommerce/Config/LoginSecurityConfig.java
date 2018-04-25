package com.grada.ecommerce.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("buyer").password("buyerpassword").authorities("ROLE_BUYER")
                .and()
                .withUser("seller").password("sellerpassword").authorities("ROLE_SELLER")
                .and()
                .withUser("admin").password("adminpassword").authorities("ROLE_BUYER","ROLE_SELLER","ROLE_ADMIN");

    }


    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeRequests()
                .antMatchers("/product").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .usernameParameter("userName").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout");

    }

    //workaround for no passwordEncoder
    //not to use in production
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
