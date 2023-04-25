package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.NoticeTypeEnum;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 管理员持久层接口
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    List<Company> selectCompany(@Param("id") String id,
                                @Param("start") Date start,
                                @Param("end") Date end,
                                @Param("address") String address,
                                @Param("flag") Integer flag);

    Boolean insertDocument(@Param("file")Document file);

    List<Document> selectDocument(@Param("id") Integer id,
                                  @Param("name") String name,
                                  @Param("flag") Integer flag);

    Integer selectDocumentCount(@Param("flag") Integer flag,
                                @Param("name") String name);

    Boolean deleteDocument(@Param("id") Integer id,
                           @Param("flag") Integer flag);

    List<Notice> selectNotices_1(@Param("id") Integer id,
                                 @Param("flag") Integer flag);

    List<Notice> selectNotices_2(@Param("type") Integer type,
                                 @Param("name") String name,
                                 @Param("timeBefore") Date timeBefore,
                                 @Param("timeLast") Date timeLast);

    Boolean updateNotice(@Param("notice") Notice notice);

    Boolean insertNotice(@Param("notice") Notice notice);

    Boolean updateNoticeFlag(@Param("id") Integer id,
                             @Param("flag") Integer flag);

    List<Recruit> selectRecruitments(@Param("id") Integer id,
                                     @Param("flag") Integer flag,
                                     @Param("companyScc") String companyScc,
                                     @Param("major") String major);

    Boolean updateRecruitmentFlag(@Param("id") Integer id,
                                  @Param("flag") Integer flag);

    List<Resume> selectResumes(@Param("flag") Integer flag,
                               @Param("id") Integer id);

    Boolean deleteResume(@Param("id") Integer id,
                         @Param("flag") Integer flag);

    Boolean insertResume(@Param("resume") Resume resume);

    List<EmployMeeting> selectMeeting(@Param("flag")Integer flag,
                                      @Param("id") Integer id);

    Boolean updateMeetingFlag(@Param("id") Integer id,
                              @Param("flag") Integer flag);

    List<String> selectAdvices(@Param("grade") Integer grade);

    Boolean updateIfOpenQuestionnaire(@Param("value") Boolean value);

    Integer countEmploymentStatus(@Param("grade") Integer grade,
                                  @Param("collage") String collage,
                                  @Param("major") String major,
                                  @Param("employmentStatus") Integer employmentStatus,
                                  @Param("workProperty") Integer workProperty);

    Map<String, Integer> employmentDistributionByCompany(@Param("grade") Integer grade,
                                                         @Param("collage") String collage,
                                                         @Param("major") String major,
                                                         @Param("workProperty") Integer workProperty);

    Map<String, Integer> employmentDistributionByWorkplace(@Param("grade") Integer grade,
                                                           @Param("collage") String collage,
                                                           @Param("major") String major,
                                                           @Param("workProperty") Integer workProperty);
}
