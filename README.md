# mySsm     
SpringBoot整合SSM(全注解   HTML   不使用.xml)

注意：此处的，主干是集合了所有的代码
              分支，是对应其那部分的代码

01.分支2019_09_08start(1)  表示，SpringBoot整合SSM的代码

02.分支2019_09_10Log(2)    表示，在01.的基础下，加入了 Lombox自搭配的@Slf4j的日志注解

03.分支2019_09_11SpringSecurity(3)_01      表示，在02.的基础上，集成了SpringSecurity   实现简单的例子，
且，使其不与之前搭配的SSM控制层的URL  冲突---->见SecurityConfig.class配置文件，指明忽略了（不拦截） /user/**的所有Url

关于Sql语句，这里面
自己的就一直是  简单的User表,至于数据内容，emmm就自己随便加吧

CREATE TABLE `user` (

  `id` varchar(228) NOT NULL,

  `name` varchar(50) DEFAULT NULL,
  
  `password` varchar(50) DEFAULT NULL,
  
  `age` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SSM测试用户表'




看完这部分代码  可以去看https://github.com/279611480/ssmandsecurity代码  与数据库打交道，因为不想在这里重开分支，将主干打乱（原本想法是纯粹的弄一个SpringBoot整合SSM  不适用xml文件的    所以，重开项目）
