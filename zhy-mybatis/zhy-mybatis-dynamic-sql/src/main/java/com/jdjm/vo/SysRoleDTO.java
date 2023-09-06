package com.jdjm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleDTO {
    private String roleName;

    private String roleCode;

    private String description;
}
