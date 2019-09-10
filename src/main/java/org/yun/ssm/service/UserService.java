package org.yun.ssm.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yun.ssm.vo.UserVO;

import java.util.List;

public interface UserService {

    @RequestMapping("/user/login")
    List<UserVO> findAll();

    @RequestMapping("/user/findByName")
    boolean findByName(@RequestParam("name") String name);

    @RequestMapping("/user/add")
    void add(@RequestParam("name") String name,@RequestParam("password") String password);

    @RequestMapping("/user/findById")
    UserVO findById(@RequestParam("id") String id);


/*
//条件查询
@RequestMapping("/factory/listPage")
PageInfo<FactoryVO> listPage(@RequestBody FactoryDTO dto);
*/
}
