# mySsm     
SpringBoot整合SSM(全注解   HTML   不使用.xml)

注意：此处的，主干是集合了所有的代码
              分支，是对应其那部分的代码

01.分支2019_09_08start(1)  表示，SpringBoot整合SSM的代码

02.分支2019_09_10Log(2)    表示，在01.的基础下，加入了 Lombox自搭配的@Slf4j的日志注解

03.分支2019_09_11SpringSecurity(3)_01      表示，在02.的基础上，集成了SpringSecurity   实现简单的例子，
且，使其不与之前搭配的SSM控制层的URL  冲突---->见SecurityConfig.class配置文件，指明忽略了（不拦截） /user/**的所有Url

关于Sql语句，这里面
自己的就一直是  简单的User表
CREATE TABLE `user` (
  `id` varchar(228) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SSM测试用户表'




