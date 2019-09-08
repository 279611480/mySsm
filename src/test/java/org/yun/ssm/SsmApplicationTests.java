package org.yun.ssm;

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

}
