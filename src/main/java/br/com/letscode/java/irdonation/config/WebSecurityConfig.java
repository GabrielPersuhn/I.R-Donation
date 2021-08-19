package br.com.letscode.java.irdonation.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //private AutenticacaoService autenticacaoService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                //.antMatchers("/cliente").permitAll()
                //.antMatchers(HttpMethod.POST, "/cliente/*").permitAll()
                //.antMatchers("/cliente/*").permitAll()
                //.antMatchers("/users/*").permitAll()
                //.antMatchers("/ong").hasAnyRole()
                .anyRequest().authenticated()
                //.and()
                //    .formLogin()
                //    .permitAll()
                //.and()
                //    .logout()
                //    .permitAll()
                .and()
                .httpBasic();

        /* httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/cursos").permitAll()
                .antMatchers("/users").hasAnyAuthority("PROFESSOR", "ADMIN", "USER")
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.GET, "/cursos/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); */

    }

    /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("bruno").password("1234@").roles("USER")
                .and().withUser("Gabriel").password("");
    } */

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // cinthia auth.userDetailsService(autenticacaoService)
                //.passwordEncoder(new BCryptPasswordEncoder()); // faz a criptografia da senha
        auth.inMemoryAuthentication()
                .withUser("pelé").password("1234").roles("USER")
                .and()
                .withUser("admin").password("3456").roles("USER", "ADMIN");
    }

    /*@Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    } */


    //Somente necessario quando tiver a camada view que é ligada ao front end
//    @Override
//    protected void configure(WebSecurity webSecurity) throws Exception {
//
//    }

}
