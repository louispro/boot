package com.louis.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "person")
public class Person {

    private String usrename;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interest;
    private List<String> animal;
    private Map<String,Integer> socre;
    private Set<Double> salarys;
    private Map<String,List<Pet>> allPets;
}
