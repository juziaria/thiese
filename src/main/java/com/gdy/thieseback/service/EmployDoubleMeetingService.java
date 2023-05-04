package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.EmployDoubleMeeting;
import com.gdy.thieseback.req.EmployDoubleMeetingReq;
import com.gdy.thieseback.req.EmployPositionReq;
import com.gdy.thieseback.resp.PageResp;
import org.springframework.stereotype.Service;

//@Mapper
@Service
public interface EmployDoubleMeetingService extends IService<EmployDoubleMeeting> {

    PageResp<EmployDoubleMeeting> getList(EmployDoubleMeetingReq employDoubleMeetingReq);

}
