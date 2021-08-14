//package br.com.letscode.java.irdonation.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//public class Segurança extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin123")
//                .roles("ADMIN");
//    }
//}
//TODO está aparecendo o mesmo que acontece no do Jessé. precisamos ver como resolver isso e como criar e autenticar um admin, se tiver alguma ideia e quiser fazer so dale