package org.yun.ssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LogController
 * @Description 2019-9-10   开始玩日志，基于Lombox自带的@Slf4j 输出日志
 *
 * spring boot 已经默认集成了slf4j,所以无需再导入其他依赖包
 *
 * spring boot 默认是加载resource目录下的logback.xml日志配置,如果没有找到再去找logback-test.xml
 *
 * 所以在resource建立logback.xml文件
 *
 *
 * @Autor 落笔丶
 * @Date 2019/9/10 17:25
 * @Tel 279611480@qq.com
 */
@Controller
@RequestMapping("/log")
@Slf4j
public class LogController {

    public static void main(String[] args) {
        int i = 1;
        try {
          int h = i/0;
        }catch (Exception e){
            e.printStackTrace();
            log.error("除数不可为0");
        }
    }

}
