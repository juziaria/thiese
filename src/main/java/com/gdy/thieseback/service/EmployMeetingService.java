package com.gdy.thieseback.service;import com.baomidou.mybatisplus.extension.service.IService;import com.gdy.thieseback.entity.EmployMeeting;import com.gdy.thieseback.req.EmployMeetingReq;import com.gdy.thieseback.resp.PageResp;public interface EmployMeetingService extends IService<EmployMeeting> {//     PageResp<EmployMeeting> getList(CommonResp<PageResp<EmployMeeting>> resp) {//    }////    List<EmployMeeting> findEmployMeeting(Date time, String name, String master, String place, String major);    //    public List<EmployMeeting> getEmployMeeting(EmployMeetingDto employMeetingDto){    //        List<EmployMeetingDto> employMeetingDto = ;    //        if(employMeetingMapper.selectById()== null){    //            return employMeetingMapper.findEmployMeeting();    //        }    //    }    //    //    @Override    //    public List<EmployMeeting> findEmployMeeting(Date time,String name,String master,String place,String major){    //    //        return EmployMeetingMapper.findEmployMeeting(time,name,master,place,major);    //    ////        List<Student> studentList = EmployMeetingMapper.findEmployMeeting();    //    }    PageResp<EmployMeeting> getList(EmployMeetingReq employMeetingReq);}