package com.danny.taxifa.securities;

import com.danny.taxifa.jwt.UserJwtAuthenticationFilter;
import com.danny.taxifa.jwt.UserJwtAuthorizationFilter;
import com.danny.taxifa.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.danny.taxifa.utils.DatabaseUtils.DATABASE_URL;
import static com.danny.taxifa.utils.TokenUtils.SIGN_UP_URL;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserService userService;


    public SecurityConfig(UserService userService){
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
     //           .cors().disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,SIGN_UP_URL).permitAll()
                .antMatchers(DATABASE_URL).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new UserJwtAuthenticationFilter(authenticationManager()))
                .addFilter(new UserJwtAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
    return source;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

//    @Override
//    public void configure (WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/v2/api-docs", "/auth/**", "/configuration/ui", "/swagger-resources/**",
//                "/configuration/security", "/configuration/**", "/swagger-ui.html", "/webjars/**", "/swagger-ui/**",DATABASE_URL);
//    }


            @Bean
            public BCryptPasswordEncoder passwordEncoder(){
                return  new BCryptPasswordEncoder();
            }



}
