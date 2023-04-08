package com.gdy.thieseback.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentInfoMapper extends BaseMapper<Student> {

    void modifiedInfo(@Param("student") Student student);

}
