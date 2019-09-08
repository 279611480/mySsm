package org.yun.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.yun.ssm.service.UserService;
import org.yun.ssm.vo.UserVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Autor 落笔丶
 * @Date 2019/9/7 22:34
 */
//4、@restcontroller注解的功能等同于@controller和@responsebody
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired(required=true)
    private UserService userService;

    /**
     *
     * @Author 落笔丶
     * @Description HelloWord     http://localhost:8080/user/test
     * @Date  2019/9/8 21:55
     * @Param
     * @return
     **/
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World !";
    }


    /**
     *
     * @Author 落笔丶
     * @Description 测试
     * @Date  2019/9/8 22:24
     * @Param
     * @returnv
     * http://localhost:8080/user/map
     **/
    @RequestMapping("/map")
    public Map<String, String> map1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "张三");
        map.put("age", "28");
        return map;
    }


    /**
    *
     * @Author 落笔丶
     * @Description  测试是否连接到数据库方法
     * @Date  2019/9/8 21:32
     * @Param
     * @return
     * http://localhost:8080/user/test
     **/
    @RequestMapping("/test")
    public void test(){
        List<UserVO> list = userService.findAll();
        if (list != null && list.size() !=0){
            for (UserVO userVO : list) {
                System.out.println(userVO.getName());
                System.out.println("连接数据库成功，查看控制台信息");
            }
        }else {
            System.out.println("连接数据库失败");
        }
    }




    /**
    *
     * @Author 落笔丶
     * @Description 首页
     * @Date  2019/9/8 21:56
     * @Param  * @param null
     * @return
     * http://localhost:8080/user/index
     **/
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }


    /**
    *
     * @Author 落笔丶
     * @Description
     * @Date  2019/9/8 22:54
     * @Param
     * @return
     **/
    //Todo 前后台交互 400  URL错误
    @GetMapping("/login")
    public String login(
            //如果请求参数里面没有loginname，默认为123
            @RequestParam(value="name",defaultValue="年轻人" ) String name,
            //如果要求请求参数里面有password这个参数，默认就是必须的
            @RequestParam(value="password",required=true) String pass
        ) {
        System.out.println("登录名：" + name);
        System.out.println("密码：" + pass);
        return ("login");
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
