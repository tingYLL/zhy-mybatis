package com.jdjm.mapper;

import com.jdjm.entity.Student;

public interface StudentMapper {

//    级联方式
    public Student queryStudent(Integer id);

//association方式
    public Student queryStudentAssociation(Integer id);

//    分步查询
    public Student queryStudentBySet(Integer sid);
}
