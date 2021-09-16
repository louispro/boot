package com.louis.boot.config;

import com.louis.boot.bean.Person;
import com.louis.boot.bean.Teacher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @赖小燚
 * @www.louis_lai.com
 */

/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods：代理bean的方法
 */
//告诉SpringBoot这是一个配置类，相当于配置文件

/**
 * 最佳实战：
 *  配置类组件之间无依赖关系用Lite模型加速容器启动过程，减少判断
 *  配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式
 */

/**
 * 如果@Configuration(proxyBeanMethods = true)则是代理对象调用方法，返回的值是从容器中获取的
 * 如果@Configuration(proxyBeanMethods = false)则是配置类本身调用方法，返回的值是新创建的
 */

/**
 * @Import会给容器中自动用这两个的类的无参构造器创建对象，默认组件的名字是全类名
 */
@Import({Teacher.class})
@Configuration(proxyBeanMethods = true)
//@ConditionalOnBean(name="satomi")   //当容器中有id为satomi的组件的时候，这个类中的注入到容器中
@ImportResource("classpath:bean.xml")
@EnableConfigurationProperties({Person.class,Teacher.class})   //1.开启car的配置绑定功能 2.把这个组件注册到容器中 3.开这个这个之后就可以实现自动装配
public class MyConfig {

    /**
     * 无论无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
//    @ConditionalOnMissingBean(name="satomi")    //容器中没有id为satomi组件的时候才注入
    @Bean  //给容器中添加组件，以方法名作为组件的id。返回类型就是组件类型，返回的值就是组件在容器中的实例，默认是单实例
    public Teacher satomi(){
        return new Teacher(1,"satomi","Japan");
    }

}
