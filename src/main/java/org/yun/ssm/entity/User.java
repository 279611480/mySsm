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
    private Integer id;
    private String name;
    private String password;
    private Integer age;

}
