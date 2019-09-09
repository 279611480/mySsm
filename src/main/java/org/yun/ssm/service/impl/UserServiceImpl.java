package org.yun.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.yun.ssm.mapper.UserMapper;
import org.yun.ssm.service.UserService;
import org.yun.ssm.vo.UserVO;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Autor 落笔丶
 * @Date 2019/9/7 22:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=true)
    UserMapper userMapper;
    //此处不是  修改  插入 删除  所以无需加上  事物注解    @Transactional
    @Override
    public List<UserVO> findAll() {
        return userMapper.findAll();
    }


    @Override
    public boolean findByName(String name) {
         String userName = userMapper.findByName(name);
         if (StringUtils.isEmpty(userName)){
             return false;
         }
         return true;
    }


    @Override
    @Transactional//开始事物注解
    public void add(String name, String password){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        userMapper.add(uuid , name,password);
    }



    /*
    @Override
    public PageInfo<FactoryVO> listPage(@RequestBody FactoryDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<FactoryVO> list = factoryMapper.listPage(dto);
        return new PageInfo<>(list);
    }
*/
}
