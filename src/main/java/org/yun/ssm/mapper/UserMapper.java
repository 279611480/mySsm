package org.yun.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import org.yun.ssm.mapper.prodiver.UserProvider;
import org.yun.ssm.vo.UserVO;

import java.util.List;

@Repository
public interface UserMapper  {

    /*    @Select("SELECT factory_name \n" +
                "FROM factory \n" +
                "WHERE is_delete = 0 \n" +
                "AND factory_name LIKE '%${name}%' \n" +
                "ORDER BY updated_time DESC ; ") */
//    @SelectProvider(method = "listPage",type = FactoryProvider.class)
//    List<FactoryVO> listPage(@Param("dto") FactoryDTO dto);



    //    @Select("select * from user")
    @SelectProvider(method = "findAll" , type = UserProvider.class)
    List<UserVO> findAll();
    @Select("SELECT name FROM user WHERE name = #{name}  ")
    String findByName(@Param("name") String name);
    //    @Insert("INSERT INTO `moxi`.`news_category` (`id`, `name`, `description`, `image`, `addDate`, `state`) VALUES (null, #{name}, #{description}, #{image}, now(), 0)")
    //INSERT INTO `user` VALUES(5,'555','888',666);
    @Insert("INSERT INTO `user` VALUES( #{uuid} ,#{name},#{password},666)")
    void add(@Param("uuid") String uuid,@Param("name") String name,@Param("password") String password);
    @Select("SELECT * FROM user WHERE id=#{id}")
    UserVO findById(@Param("id") String id);

    //    @Update("UPDATE ad_space SET copy_id = #{copyId} WHERE id = #{id}")
}