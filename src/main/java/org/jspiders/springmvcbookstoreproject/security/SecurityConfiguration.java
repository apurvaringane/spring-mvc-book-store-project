package org.jspiders.springmvcbookstoreproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    //authentication
//    @Bean
//    public InMemoryUserDetailsManager userDetails(){
//        UserDetails apurva= User.builder()
//                .username("apurva")
//                .password("{noop}123")
//                .roles("DEALER","VENDOR","CUSTOMER")
//                .build();
//
//        UserDetails ankita=User.builder()
//                .username("ankita")
//                .password("{noop}456")
//                .roles("VENDOR","CUSTOMER")
//                .build();
//
//        UserDetails arpita=User.builder()
//                .username("arpita")
//                .password("{noop}789")
//                .roles("CUSTOMER")
//                .build();
//
//        return new InMemoryUserDetailsManager(apurva,ankita,arpita);
//    }

@Bean
    public UserDetailsManager UserDetails(DataSource dataSource){
    return new JdbcUserDetailsManager(dataSource);
  }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(config->
            config
                    .requestMatchers("/").hasAnyRole("ADMIN","USER")
                    .requestMatchers("/bookhome").hasAnyRole("ADMIN","USER")
                    .requestMatchers("/get-book-form").hasRole("ADMIN")
                    .requestMatchers("/update/{id}").hasAnyRole("ADMIN")
                    .requestMatchers("/updatebook").hasRole("ADMIN")
                    .requestMatchers("/delete/{id}").hasAnyRole("ADMIN")
                    .requestMatchers("/search").permitAll()
                    .anyRequest().authenticated())
        .formLogin(Customizer.withDefaults())
            .exceptionHandling(config->
                    config.accessDeniedPage("/access-denied"));
    return http.build();
    }

}
