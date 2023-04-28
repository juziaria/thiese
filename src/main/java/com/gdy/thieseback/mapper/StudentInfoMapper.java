package com.gdy.thieseback.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StudentInfoMapper extends BaseMapper<Student> {

    void modifiedInfo(@Param("student") Student student);

    List<Document> selectDocument(@Param("id") Integer id,
                                  @Param("flag") Integer flag);

}
