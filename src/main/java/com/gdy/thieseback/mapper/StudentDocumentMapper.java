package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 学生端持久层接口
 */
@Mapper
public interface StudentDocumentMapper extends BaseMapper<Document> {

    List<Document> selectDocument(@Param("id") Integer id,
                                  @Param("name") String name,
                                  @Param("flag") Integer flag);

    Integer selectDocumentCount(@Param("flag") Integer flag,
                                @Param("name") String name);


}
