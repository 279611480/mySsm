package org.yun.ssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author 落笔丶
 * @Description
 * 当使用admin登录后，若需要使用user登录，则需要先访问/security/exit退出登录状态后，重新访问/securirty/login页面，使用user/123登录。才能去访问user的页面（权限决定的）
 * @Date  2019/9/12 23:43
 **/

@Controller
@RequestMapping("/security")
@Slf4j
public class SpringSecurityTestController {
    @GetMapping("/index")
    public String index() {
        // 默认首页，谁都可以访问
        log.debug("开始首页");
        //倘若自己的html  有新建文件夹security   应该是return "security/security-index";
        return "security-index";
    }

    @GetMapping("/login")
    public String login() {
        // 登录页面，谁都可以访问
        return "security-login";
    }

    @GetMapping("/error")
    @ResponseBody
    public String error() {
        // 登录失败页面，所有用户登录失败时提示错误信息
        return "登录失败，账号密码错误";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        // hello 请求，任务用户都可以访问
        return "hello";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        // 信息页面，只有 ADMIN 角色才能访问
        return "admin ";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        // 信息页面，只有 USER 角色才能访问
        return "user";
    }

}