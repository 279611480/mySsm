package org.yun.ssm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yun.ssm.service.UserService;
import org.yun.ssm.vo.UserVO;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SsmApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void test() {
        List<UserVO> all = userService.findAll();
        for (UserVO userVO : all) {
            System.out.println(userVO.getName());
        }
    }

    /**
    *
     * @Author 落笔丶
     * @Description  测试log日志
     * @Date  2019/9/10 21:44
     * @Param  * @param null
     * @return
     **/
    @Test
    public void logTest(){
        String id = "1";
        log.info("测试开始~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        UserVO userVO = userService.findById(id);
        log.info("测试结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }
}
