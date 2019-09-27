package org.yun.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.yun.ssm.service.UserService;
import org.yun.ssm.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description
 * @Autor 落笔丶
 * @Date 2019/9/7 22:34
 */


/**
* 倘若正式开发（公司），自己不是全栈式，那么，此处@Controller  应该改为 @RestController   或者不变，但是在每个方法上面加上注解@ResposeBody表示返回Json数据给前台
* */

//4、@RestController注解的功能等同于@controller和@responsebody
// responsebody就是标识方法只返回字符串不进行视图跳转
    //如果，公司，自己只负责后台   那么，可以使用此注解
    //像这个 因为是自己玩  前后台交互 下面的 login   ，加上@RestControlletr会报400 URL错误
//@RestController
@Controller
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
     * @Description 前后台交互   跳转至login页面
     * 1)参看https://blog.csdn.net/qq_40391559/article/details/82856868     -->当required 不为 false时  会报错   required string parameter 'XXX'is not present
     * 2)如果，非要true  检查前台页面  与  此处的 name是否相同  emmm此处相同还是如此，所以我改为了false
     * 3)此处，非要true,解决方法就是  加上默认值 defaultValue="123"   上面报错，可以理解 是因为自己，是第一次跳转此页面，所以一直拿不到值  是正常的
     * @Date  2019/9/8 22:54
     * @Param
     * @return
     * http://localhost:8080/user/login
     **/
 /*
    *每次都有值 ----------->正式开发   应该此方法
     *  登录名：年轻人
    密码：1234

    登录名：11
    密码：11
    * */
    @GetMapping("/login")
    public String login(
            @RequestParam(value = "name" ,required = true, defaultValue = "年轻人") String name,
            //如果要求请求参数里面有password这个参数，默认就是必须的
            @RequestParam(value = "password" , required = true ,defaultValue = "1234") String password
    ) {
        System.out.println("登录名：" + name);
        System.out.println("密码：" + password);
        return "login";
    }


    /*
    * 登录名：null
    密码：null

    登录名：111
    密码：111
        *
    * */
    @GetMapping("/login3")
    public String login3(

            @RequestParam(value = "name" ,required = false) String name,
            //如果要求请求参数里面有password这个参数，默认就是必须的
            @RequestParam(value = "password" , required = false) String password,
            HttpServletRequest request
    ) {
        System.out.println("登录名：" + request.getParameter("name"));
        System.out.println("密码：" + request.getParameter("password"));
        return "login";
    }


    /*
    * 第一次没值（这里没有值，很正常，以为调用的是从  request中获取，请求参数，所以没有值，是正常的【第一次无值】      而login方法一开始就有值，是因为一开始就没有使用request方法）
    * 登录名：null
    密码：null
    //输入改变
    登录名：123
    密码：123
    * */
    @GetMapping("/login2")
    public String login2(

            @RequestParam(value = "name" ,required = true, defaultValue = "年轻人") String name,
            //如果要求请求参数里面有password这个参数，默认就是必须的
            @RequestParam(value = "password" , required = true ,defaultValue = "1234") String password,
            HttpServletRequest request
    ) {
        System.out.println("登录名：" + request.getParameter("name"));
        System.out.println("密码：" + request.getParameter("password"));
        return "login";
    }


    /**
    *
     * @Author 落笔丶
     * @Description 注册
     * @Date  2019/9/9 22:52
     * @Param  * @param null
     * @return
     **/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody//此处算是，正常的前后台交互，前台传数据，后台接收，且业务处理      需要加上此注解，否则报错org.thymeleaf.exceptions.TemplateInputException:   需要返回Json数据  而不是@Controller的Spring视图了
    public String register(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            return "用户名，或者密码为空";
        }
        if(userService.findByName(name) == true){
            return "该用户名已被注册";
        }
        userService.add(name,password);
        return "注册成功";
    }

    @PostMapping("/register2")
    public ModelAndView register2(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        ModelAndView modelAndView = new ModelAndView();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
           modelAndView.addObject("message","注册用户名与密码不可为空");
           modelAndView.setViewName("failed");
           return modelAndView;
        }
        if(userService.findByName(name) == true){
            modelAndView.addObject("message","该用户名已被注册");
            modelAndView.setViewName("failed");
            return modelAndView;
        }
        userService.add(name,password);
        System.out.println("注册成功，跳转至登录页");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
    *
     * @Author 落笔丶
     * @Description 真正意义上的，登录----（1）一开始，未登录过，所以，拿不到任何用回信息（2）加上用户是不可以重复的（3）所以，此处登录完全不做任何，关于findById的处理
     * @Date  2019/9/9 23:21
     * @Param  * @param null
     * @return
     **/
    @RequestMapping("/loginEnd")
    public String loginEnd(WebRequest request){//request也可以这么拿  SpringMvc中
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)   ){
            System.out.println("登录失败");
            return "failed";
        }
        List<UserVO> all = userService.findAll();
        for (UserVO userVO : all) {
            if (userVO.getName().equals(name) && userVO.getPassword().equals(password)) {
                //登录成功
                return "index";
            }
        }
        //登录失败
        return "用户名  密码未注册";
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
