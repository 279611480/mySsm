package org.yun.ssm.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Autor 落笔丶
 * @Date 2019/9/7 22:38
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
//    @GeneratedValue(generator="uuid2")
//    @GenericGenerator(name="uuid2",strategy="uuid2")
//    @Column(length=36)    //Sring类型的id  长度为36的uuid
    private String id;
    private String name;
    private String password;
    private Integer age;


    /*
   // 使用了@Entity注解的类里面，必须有@Id注解的属性，表示主键
    @Id
    // 主键是要自动生成的，可以使用主键生成器
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    * */

}
