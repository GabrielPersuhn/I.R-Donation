package br.com.letscode.java.irdonation.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                //Aqui um exemplo de como são colocados os requests liberados para todos ser precisar de login
                .antMatchers(HttpMethod.GET,"/cliente").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .permitAll()
                    .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin123")
                .roles("ADMIN");
    }


    //Somente necessario quando tiver a camada view que é ligada ao front end
//    @Override
//    protected void configure(WebSecurity webSecurity) throws Exception {
//
//    }

}
//TODO está aparecendo o mesmo que acontece no do Jessé. precisamos ver como resolver isso e como criar e autenticar um admin, se tiver alguma ideia e quiser fazer so dale