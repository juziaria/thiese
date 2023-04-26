package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.*;
import com.gdy.thieseback.util.AdminToolHelper;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.util.ListHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 管理员业务层
 */
@Service
@Transactional
public class AdminDocumentServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminDocumentService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();




    @Override
    public Boolean uploadDocument(Document document) {
        return adminMapper.insertDocument(document);
    }

    @Override
    public Boolean downloadDocument(String saveDirPath, Integer id) {
        Document document = ListHelper.FirstOrDefault(adminMapper.selectDocument(id, null, FlagEnum.Upload.getCode()));
        String savePath = document.getSavaPath(saveDirPath);
        try {
            document.save(savePath);
        }catch (Exception EX){
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteDocument(Integer id) {
        return adminMapper.deleteDocument(id, FlagEnum.Delete.getCode());
    }

    @Override
    public List<DocumentInfo> showDocuments(String name) {
        List<Document> documents =  adminMapper.selectDocument(null, name, FlagEnum.Upload.getCode());
        List<DocumentInfo> documentInfoList = new ArrayList<>();

        for(Document document : documents){
            DocumentInfo documentInfo = conversation.DocumentToDocumentInfo(document);
            documentInfoList.add(documentInfo);
        }

        return documentInfoList;
    }

    @Override
    public Document selectDocument(Integer id, String name) {
        return ListHelper.FirstOrDefault(adminMapper.selectDocument(id, name, 0));
    }

    @Override
    public Integer selectDocumentCount(String name) {
        return adminMapper.selectDocumentCount(FlagEnum.Upload.getCode(), name);
    }

}
