package com.gdy.thieseback.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 学生端持久层接口
 */

@Mapper
public interface StudentMapper extends BaseMapper<Student>{
//
//    List<Document> selectDocument(@Param("id") Integer id,
//                                  @Param("flag") Integer flag);
}

