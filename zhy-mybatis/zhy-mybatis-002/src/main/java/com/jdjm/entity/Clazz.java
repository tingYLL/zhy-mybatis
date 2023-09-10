package com.jdjm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 班级类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clazz {
     private Integer id;

     private String name;
}
