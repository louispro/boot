package com.louis.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
//@Component  //@Component和ConfigurationProperties配合使用可以将组件注册到到容器中并且自动装配值
@ConfigurationProperties(prefix = "myteacher")
public class Teacher {

    private  Integer id;
    private String name;
    private String address;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
