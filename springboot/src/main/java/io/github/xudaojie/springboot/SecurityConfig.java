package io.github.xudaojie.springboot;

/**
 * Created by xdj on 2017/5/18.
 */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http
//                .authorizeRequests()
//                .antMatchers("/").access("hasRole('READER')")
//                .antMatchers("/**").permitAll()
//
//                .and()
//
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error=true");
//    }
//}
public class SecurityConfig {

}