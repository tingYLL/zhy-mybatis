package com.jdjm.mybatis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {
    private Integer id;
    private Integer userId;
    private String name;
    private String title;
    private String story;
    private Integer isDeleted;
    private String createAt;
    private String updateAt;
    private Integer tag;

}
