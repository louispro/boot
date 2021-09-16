package com.louis.boot.bean;

import lombok.*;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Data   //添加get和set方法
@NoArgsConstructor  //无参构造器
@AllArgsConstructor //有参构造器
@ToString   //tostring方法
@EqualsAndHashCode  //equals和hashcode
public class Student {

    private Integer id;
    private String name;
}
