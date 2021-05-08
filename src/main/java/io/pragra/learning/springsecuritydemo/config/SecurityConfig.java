package io.pragra.learning.springsecuritydemo.config;

import io.pragra.learning.springsecuritydemo.utils.UserRoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/student/**").hasAnyRole(UserRoles.ADMIN)
                .antMatchers(HttpMethod.DELETE,"/api/student/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/student/**").permitAll()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable().headers().frameOptions().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/")
                .antMatchers("/about");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails normalUser =
                User.withDefaultPasswordEncoder().username("user").password("user").roles(UserRoles.USER).build();
        UserDetails adminUser =
                User.withDefaultPasswordEncoder().username("admin").password("admin").roles(UserRoles.USER, UserRoles.ADMIN).build();
        return new InMemoryUserDetailsManager(normalUser,adminUser);
    }
}
