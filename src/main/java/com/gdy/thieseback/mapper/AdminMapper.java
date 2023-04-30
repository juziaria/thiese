package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.dto.MeetingInfo;
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
                                 @Param("timeLast") Date timeLast,
                                 @Param("flag") Integer flag);

    Boolean updateNotice(@Param("notice") Notice notice);

    Integer insertNotice(@Param("notice") Notice notice);

    Boolean updateNoticeFlag(@Param("id") Integer id,
                             @Param("flag") Integer flag);

    List<Recruit> selectRecruitments(@Param("id") Integer id,
                                     @Param("flag") Integer flag,
                                     @Param("companyScc") String companyScc);

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

    Boolean InsertMeeting(@Param("meeting") EmployMeeting employMeeting);

    //TODO
    List<String> selectAdvices(@Param("grade") Integer grade,
                               @Param("major") String major);

    Boolean updateIfOpenQuestionnaire(@Param("value") Boolean value);

    //数据分析
    Map<Integer, Integer> CountMeetingType(@Param("year") Integer year,
                                           @Param("notFlag") Integer notFlag);

    Map<String, Integer> CountMeetingForMajor(@Param("year") Integer year,
                                              @Param("notFlag") Integer notFlag);

    Map<Integer, Integer> countEmploymentStatus(@Param("grade") Integer grade,
                                                @Param("collage") String collage,
                                                @Param("major") String major,
                                                @Param("workProperty") Integer workProperty);

    Map<String, Integer> employmentDistributionByCompany(@Param("grade") Integer grade,
                                                         @Param("collage") String collage,
                                                         @Param("major") String major,
                                                         @Param("workProperty") Integer workProperty);

    Map<String, Integer> employmentDistributionByWorkplace(@Param("grade") Integer grade,
                                                           @Param("collage") String collage,
                                                           @Param("major") String major,
                                                           @Param("workProperty") Integer workProperty);

    Map<String, Integer> employmentDistributionByIndustry(@Param("grade") Integer grade,
                                                           @Param("collage") String collage,
                                                           @Param("major") String major,
                                                           @Param("workProperty") Integer workProperty);

    Map<String, Integer> employmentDistributionByPosition(@Param("grade") Integer grade,
                                                           @Param("collage") String collage,
                                                           @Param("major") String major,
                                                           @Param("workProperty") Integer workProperty);

    Map<Integer, Integer> employmentDistributionByCompanyProperty(@Param("grade") Integer grade,
                                                                 @Param("collage") String collage,
                                                                 @Param("major") String major,
                                                                 @Param("workProperty") Integer workProperty);

    Map<String, Integer> salaryDistributionByIndustry(@Param("workProperty") Integer workProperty,);

    Map<String, Integer> salaryDistributionByPosition(@Param("workProperty") Integer workProperty);

    Map<String, Integer> salaryDistributionByWorkPlace(@Param("workProperty") Integer workProperty);

    Map<String, Integer> salaryDistributionByCompany(@Param("workProperty") Integer workProperty);

    Map<Integer, Integer> salaryDistributionByCompanyProperty(@Param("workProperty") Integer workProperty);
}
