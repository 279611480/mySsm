package org.yun.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages ="org.yun")
//@ComponentScan(value="org.yun",excludeFilters= {@ComponentScan.Filter(classes= {Controller.class})})//包扫描
@MapperScan("org.yun.ssm.mapper")
@EnableTransactionManagement // 激活注解的事务管理器配置
public class SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmApplication.class, args);
    }

}
