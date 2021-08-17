package br.com.letscode.java.irdonation.config;

import br.com.letscode.java.irdonation.autenticacao.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/cliente").permitAll()
                .antMatchers("/cliente/*").permitAll()
                .antMatchers("/users/*").permitAll()
                //.antMatchers("/ong").hasAnyRole()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("bruno").password("1234@").roles("USER")
                .and().withUser("Gabriel").password("");
    }

    //public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.userDetailsService(autenticacaoService)
    //            .passwordEncoder(new BCryptPasswordEncoder());
    //}

    @Bean // faz a criptografia da senha
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //Somente necessario quando tiver a camada view que é ligada ao front end
//    @Override
//    protected void configure(WebSecurity webSecurity) throws Exception {
//
//    }
}
//TODO está aparecendo o mesmo que acontece no do Jessé. precisamos ver como resolver isso e como criar e autenticar um admin, se tiver alguma ideia e quiser fazer so dale