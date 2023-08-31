package com.jdjm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private String id;

    private String roleName;

    private String roleCode;

    private String description;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;
}
