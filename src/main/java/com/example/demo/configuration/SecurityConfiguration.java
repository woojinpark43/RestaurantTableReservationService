package com.example.demo.configuration;

import com.example.demo.Users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserAuthenticationFailureHandler getFailureHandler() {
        return new UserAuthenticationFailureHandler();
    }

    @Bean
    CustomLogoutSuccessHandler getLogoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    CustomAuthenticationSuccessHandler getSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/", "/member/register",
                        "/kiosk",
                        "/partner/register", "/partner/index")
                .permitAll();

        http.authorizeRequests().antMatchers("/admin/**")
                .hasAuthority("ROLE_ADMIN");

        http.formLogin()
                .loginPage("/login")
                .failureHandler(getFailureHandler())
                .successHandler(getSuccessHandler())
                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessHandler(getLogoutSuccessHandler())
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        http.exceptionHandling()
                .accessDeniedPage("/error/denied");

        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(getPasswordEncoder());
        super.configure(auth);
    }


}
