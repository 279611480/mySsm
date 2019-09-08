package org.yun.ssm.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.yun.ssm.vo.UserVO;

import java.util.List;

public interface UserService {

    @RequestMapping("/userlogin/login")
    List<UserVO> findAll();

/*
//条件查询
@RequestMapping("/factory/listPage")
PageInfo<FactoryVO> listPage(@RequestBody FactoryDTO dto);
*/
}
