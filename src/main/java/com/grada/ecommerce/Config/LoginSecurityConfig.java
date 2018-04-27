package com.grada.ecommerce.Config;

import com.grada.ecommerce.Services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter
{  
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    { authenticationManagerBuilder.authenticationProvider(authenticationProvider());
        /*
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("buyer").password("buyerpassword").authorities("ROLE_BUYER")
                .and()
                .withUser("seller").password("sellerpassword").authorities("ROLE_SELLER")
                .and()
                .withUser("admin").password("adminpassword").authorities("ROLE_BUYER","ROLE_SELLER","ROLE_ADMIN");
*/

    }


    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
       httpSecurity.authorizeRequests()
                .antMatchers("/pruduct/add").hasRole("Seller")
                .antMatchers("/pruduct/seller-analytics").hasRole("Seller")
                .antMatchers("/product/delete").hasRole("Seller")
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .usernameParameter("userName").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .logoutUrl("/logout")
                .invalidateHttpSession(true);
         
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
    //workaround for no passwordEncoder
    //not to use in production
    /*
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
*/
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
    
}
