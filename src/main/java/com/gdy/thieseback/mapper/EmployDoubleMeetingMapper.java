package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.EmployDoubleMeeting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface EmployDoubleMeetingMapper extends BaseMapper<EmployDoubleMeeting> {

    List<EmployDoubleMeeting> findEmployPosition(@Param("meetingtime") Date meetingtime,@Param("interviewtime") Date interviewtime, @Param("name") String name, @Param("master") String master, @Param("place") String place, @Param("major") String major);

}
