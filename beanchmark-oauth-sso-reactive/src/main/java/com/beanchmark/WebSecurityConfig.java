package com.beanchmark;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.DefaultLettucePool;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        LettuceConnectionFactory lettuceConnectionFactory =
//                new LettuceConnectionFactory(
//                        new RedisStandaloneConfiguration("10.10.101.161", 6379));
//        lettuceConnectionFactory.setShareNativeConnection(false);
//        return lettuceConnectionFactory;
//    }

    @Bean
    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(4);
//        return new MessageDigestPasswordEncoder("MD5");
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder(4).encode("password"));
        System.out.println(new MessageDigestPasswordEncoder("MD5").encode("password"));
    }
}