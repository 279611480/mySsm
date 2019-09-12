package org.yun.ssm.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
*
 * @Author 落笔丶
 * @Description
 * 定义了登录页面、登录失败页面、退出页面、退出成功页面等相关配置，这与控制器相对应。
 *
 * 其中，配置了2个固定的用户，分别是 admin（密码是123），角色是ADMIN，第二个用户是user（密码是123），角色是USER。
 * @Date  2019/9/12 23:32

 **/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/img/**");
     //   web.ignoring().antMatchers("/lib/**");
        //解决服务注册url被拦截的问题  不加的话，会把自己的之前的url全部，替换成SpringSecurity自带的登录页
        web.ignoring().antMatchers("/user/**");

    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("SecurityConfig.configure > http");

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/security/hello").permitAll() // 此页面允许任何人访问，即使未登录
                .antMatchers("/security/admin").hasAnyRole("ADMIN") // 仅允许 ADMIN 角色的用户访问
                .antMatchers("/security/user").hasAnyRole("USER") // 仅允许 USER 角色的用户访问
                .anyRequest().denyAll() // 其他资源禁止访问
                .and()
                .formLogin()
                .loginPage("/security/login") // 自定义登录页面
                .failureUrl("/security/error") // 登录错误页面
                .permitAll() // 允许任何用户访问
                .and()
                .logout()
                .logoutUrl("/security/exit") // 退出登录
                .logoutSuccessUrl("/security/index") // 退出登录成功返回的页面
                .permitAll() // 也允许任务用户访问
                .and()
                .exceptionHandling();
      /*  //解决中文乱码问题
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);*/

    }

    /*自定义生成两个带有权限的用户
    *  * 其中，配置了2个固定的用户，分别是 admin（密码是123），角色是ADMIN，第二个用户是user（密码是123），角色是USER。

     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("SecurityConfig.configure > withUser");

        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("ADMIN")
                .and()
                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("USER");
    }

}