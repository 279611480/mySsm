//package org.yun.ssm.util;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.ComponentScan;
//
///**
// * @ClassName ApplicationContextUtil
// * @Description TODO
// * @Autor 落笔丶
// * @Date 2019/9/8 11:37
// */
//@ComponentScan
//public class ApplicationContextUtil implements ApplicationContextAware {
//    //     Spring应用上下文环境  
//    private static ApplicationContext applicationContext;
//            /** 
//          * 实现ApplicationContextAware接口的回调方法，设置上下文环境 
//          *  
//          * @param applicationContext 
//          */
//             public void setApplicationContext(ApplicationContext applicationContext) {
//                 this.applicationContext = applicationContext;
//                }
//            /** 
//          * @return ApplicationContext 
//          */
//            public static ApplicationContext getApplicationContext() {
//                return applicationContext;
//            }
//            /** 
//          * 获取对象 
//          * 这里重写了bean方法，起主要作用 
//          * @param name 
//          * @return Object 一个以所给名字注册的bean的实例 
//          * @throws BeansException 
//          */
//            public static Object getBean(String name) throws BeansException {
//                return getApplicationContext().getBean(name);
//            }
//             public static <T> T getBean(Class<T> requiredType) {
//                 return getApplicationContext().getBean(requiredType);
//            }
//
//
//}
