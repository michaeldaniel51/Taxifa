package com.danny.Taxifa.securities;

import com.danny.Taxifa.jwt.UserJwtAuthenticationFilter;
import com.danny.Taxifa.jwt.UserJwtAuthorizationFilter;
import com.danny.Taxifa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


        @Autowired
        private UserService userService;




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.headers().frameOptions().disable();
//        http.cors()
//                .disable()
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .anyRequest().permitAll();
//    }



//    private final UserService userService;
//    private final String expires;
//
//    public SecurityConfig(UserService userService, @Value( "${app.token.expires:5}") String expires){
//        this.userService = userService;
//        this.expires = expires;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .cors().disable()
//                .authorizeRequests().antMatchers("/swagger-ui/**").permitAll()
//                .antMatchers("/user/**","/user/auth/","/auth/**").permitAll()
//           .antMatchers("/users/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .addFilter(new UserJwtAuthenticationFilter(authenticationManager(),expires))
//                .addFilter(new UserJwtAuthorizationFilter(authenticationManager()))
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .httpBasic().disable()
//                .formLogin().disable();
//    }
//
//
//
//    @Override
//    public void configure (WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
//                "/configuration/security", "/configuration/**", "/swagger-ui.html", "/webjars/**", "/swagger-ui/**", "/h2-console");
//    }
//

            @Bean
            public BCryptPasswordEncoder passwordEncoder(){
                return  new BCryptPasswordEncoder();
            }



}
