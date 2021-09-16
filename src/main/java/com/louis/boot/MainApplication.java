package com.louis.boot;

import com.louis.boot.bean.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @赖小燚
 * @www.louis_lai.com
 */

/**
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);
       //查看容器里面的组件
//       String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//
//        //从容器中获取组件
//        Teacher teacher1 = run.getBean("satomi",Teacher.class);
//        Teacher teacher2 = run.getBean("satomi",Teacher.class);
//        System.out.println(teacher1);
//        System.out.println("是否是单实例："+String.valueOf(teacher2==teacher1));
//        Teacher sakura = run.getBean("sakura",Teacher.class);
//        System.out.println("sakura："+sakura);
    }
}
