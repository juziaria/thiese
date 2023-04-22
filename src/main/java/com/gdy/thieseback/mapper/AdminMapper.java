package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 管理员持久层接口
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    List<String> selectStuCollage(@Param("flag") Integer flag);

    List<Integer> selectStuGrade(@Param("flag") Integer flag);

    List<String> selectStuMajor(@Param("flag") Integer flag);

    List<Integer> selectStuClass(@Param("flag") Integer flag);

    List<String> selectCompanyAddress(@Param("flag") Integer flag);

    Boolean deleteStu(@Param("id") String id,
                     @Param("flag") Integer flag);

    Boolean deleteCompany(@Param("id") String id,
                     @Param("flag") Integer flag);

    List<Student> selectStu(@Param("grade") Integer grade,
                            @Param("collage") String collage,
                            @Param("major") String major,
                            @Param("stuClass") Integer stuClass,
                            @Param("flag") Integer flag);

    Employment selectEmployment(@Param("studentId") String studentId);

    List<Company> selectCompany(@Param("id") String id,
                                @Param("start") Date start,
                                @Param("end") Date end,
                                @Param("address") String address,
                                @Param("flag") Integer flag);

    Boolean updateStu(@Param("student") Student student);

    Boolean updateCompany(@Param("company")Company company);

    Boolean insertDocument(@Param("file")Document file);

    List<Document> selectDocument(@Param("id") Integer id,
                                  @Param("flag") Integer flag);

    Integer selectDocumentCount(@Param("flag") Integer flag);

    Boolean deleteDocument(@Param("id") Integer id,
                           @Param("flag") Integer flag);

    List<Notice> selectNotices(@Param("id") Integer id,
                               @Param("flag") Integer flag);

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

    List<Meeting> selectMeeting(@Param("flag")Integer flag,
                                @Param("id") Integer id);

    Boolean updateMeetingFlag(@Param("id") Integer id,
                              @Param("flag") Integer flag);

    MeetingLocation selectMeetingLocation(@Param("id") Integer id);

    Boolean updateMeetingLocation(@Param("id") Integer id,
                                  @Param("locationId")Integer locationId);

    List<MeetingLocation> selectEmptyMeetingLocation(@Param("flag") Integer flag,
                                                     @Param("id") Integer id);

    Boolean updateMeetingLocationFlag(@Param("flag") Integer flag,
                                      @Param("id") Integer id);

    List<String> selectAdvices(@Param("grade") Integer grade);

    Boolean updateIfOpenQuestionnaire(@Param("value") Boolean value);
}
