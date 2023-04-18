package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.EmployPosition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployPositionMapper extends BaseMapper<EmployPosition> {

    List<EmployPosition> findEmployPosition(@Param("availbletime") Date availbletime, @Param("jobname") String jobname, @Param("comname") String comname, @Param("workplace") String workplace, @Param("major") String major, @Param("degree") String degree, @Param("pay") String pay, @Param("flag") Integer flag);

}
