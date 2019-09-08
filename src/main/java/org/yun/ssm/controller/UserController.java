package org.yun.ssm.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yun.ssm.service.UserService;
import org.yun.ssm.service.impl.UserServiceImpl;
import org.yun.ssm.vo.UserVO;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Autor 拾笔丶
 * @Date 2019/9/7 22:34
 */
//4、@restcontroller注解的功能等同于@controller和@responsebody
@RestController("/user")
public class UserController {

    @Autowired(required=true)
    private UserService userService;

    //跳转首页（登录页）
    @RequestMapping("/toIndex")
    public String show(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "name") String name ,
                        @RequestParam(name = "password") String password){
        if (!StringUtils.isEmpty("name") && !StringUtils.isEmpty("")){
            //查找姓名  与  密码是否相等
            List<UserVO> list = userService.findAll();
            if (list.contains(name) && list.contains(password)){
                return "登录成功";
            }
        }
        return "账号名或密码为空 OR null";
    }





    /*  @RequestMapping("/listPage")
    public ResultVO<?> listPage(@RequestBody FactoryDTO dto){
        try {
            PageInfo pageInfo =factoryService.listPage(dto);
            dto.setTotal(pageInfo.getTotal());
            dto.setPages(pageInfo.getPages());
            return ResultSupport.successfy(pageInfo.getList(),dto);
        }catch (Exception e){
            log.error("查询失败");
            return ResultSupport.fail("查询失败");
        }
    }*/
}
