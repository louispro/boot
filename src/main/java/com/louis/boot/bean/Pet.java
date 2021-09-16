package com.louis.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @赖小燚
 * @www.louis_lai.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {
    private String name;
    private Double weight;
}
