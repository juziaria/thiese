package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 管理员持久层接口
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    List<Admin> findAdmin(@Param("id") String id,
                          @Param("pwd") String pwd,
                          @Param("flag") Integer flag);

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

    List<Company> selectCompany(@Param("id") String id,
                                @Param("start") Date start,
                                @Param("end") Date end,
                                @Param("address") String address,
                                @Param("flag") Integer flag);

    Boolean initialStuPassword(@Param("id") String id,
                               @Param("pwd") String pwd);

    Boolean initialCompanyPassword(@Param("id") String id,
                                   @Param("pwd") String pwd);

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

    Boolean insertRecruitment(@Param("recruitment") Recruitment recruitment);

    Boolean insertRequirement(@Param("requirement") Requirement requirement);

    List<String> selectWorkPlace();

    List<Recruitment> selectRecruitments(@Param("flag") Integer flag,
                                         @Param("salaryMin") Integer salaryMin,
                                         @Param("salaryMax") Integer salaryMax,
                                         @Param("workPlace") String workPlace);

    Requirement selectRequirement(@Param("id") Integer id);

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

    Boolean updateMeetingClassroom(@Param("id") Integer id,
                                   @Param("classroomId")Integer classroomId);

    List<Classroom> selectEmptyClassroom(@Param("flag") Integer flag,
                                         @Param("id") Integer id);

    Boolean updateEmptyClassroomFlag(@Param("flag") Integer flag,
                                     @Param("id") Integer id);

    List<String> selectAdvices(@Param("grade") Integer grade);

    Boolean updateIfOpenQuestionnaire(@Param("value") Boolean value);
}
