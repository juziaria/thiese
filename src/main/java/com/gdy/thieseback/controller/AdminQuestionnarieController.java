package com.gdy.thieseback.controller;


import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.service.IAdminQuestionnaireService;
import com.gdy.thieseback.util.Conversation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员控制层_问卷
 */
@RestController
@RequestMapping("/gdy/admin")
@Api(tags = "管理员端")
public class AdminQuestionnarieController {
    @Autowired
    private IAdminQuestionnaireService IAdminQuestionnaireService;

    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();
}
