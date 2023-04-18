package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.EmployPosition;
import com.gdy.thieseback.req.EmployPositionReq;
import com.gdy.thieseback.resp.PageResp;

public interface EmployPositionService extends IService<EmployPosition> {

    PageResp<EmployPosition> getList(EmployPositionReq employPositionReq);

}
