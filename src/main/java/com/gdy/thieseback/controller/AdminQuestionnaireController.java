package com.gdy.thieseback.controller;


import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.service.IAdminQuestionnaireService;
import com.gdy.thieseback.util.Conversation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员控制层_问卷
 */
@RestController
@RequestMapping("/gdy/admin/questionnaire")
@Api(tags = "管理员端")
public class AdminQuestionnaireController {
    @Autowired
    private IAdminQuestionnaireService IAdminQuestionnaireService;

    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();

    @ApiOperation("结束")
    @GetMapping("/showAdvices")
    public List<String> showAdvices(@RequestParam Integer grade,
                                    @RequestParam String major){
        return IAdminQuestionnaireService.showAdvices(grade, major);
    }

    @ApiOperation("结束")
    @GetMapping("/openQuestionnaire")
    public Boolean openQuestionnaire(){
        return IAdminQuestionnaireService.updateIfOpenQuestionnaire(true);
    }

    @ApiOperation("结束")
    @GetMapping("/closeQuestionnaire")
    public Boolean closeQuestionnaire(){
        return IAdminQuestionnaireService.updateIfOpenQuestionnaire(false);
    }
}
