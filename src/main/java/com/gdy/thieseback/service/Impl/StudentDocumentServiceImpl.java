package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.dto.DocumentInfo;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Student;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.mapper.StudentDocumentMapper;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.service.IStudentDocumentService;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.util.ListHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员业务层
 */
@Service
//@Transactional
public class StudentDocumentServiceImpl extends ServiceImpl<StudentDocumentMapper, Document> implements IStudentDocumentService {
    @Resource
    private StudentDocumentMapper studentDocumentMapper;

    @Resource
    private final Conversation conversation = new Conversation();


    @Override
    public Boolean downloadDocument(String saveDirPath, Integer id) {
        Document document = ListHelper.FirstOrDefault(studentDocumentMapper.selectDocument(id, null, FlagEnum.Upload.getCode()));
        String savePath = document.getSavaPath(saveDirPath);
        try {
            document.save(savePath);
        }catch (Exception EX){
            return false;
        }
        return true;
    }

    @Override
    public List<DocumentInfo> showDocuments(String name) {
        List<Document> documents =  studentDocumentMapper.selectDocument(null, name, FlagEnum.Upload.getCode());
        List<DocumentInfo> documentInfoList = new ArrayList<>();

        for(Document document : documents){
            DocumentInfo documentInfo = conversation.DocumentToDocumentInfo(document);
            documentInfoList.add(documentInfo);
        }

        return documentInfoList;
    }

    @Override
    public Document selectDocument(Integer id, String name) {
        return ListHelper.FirstOrDefault(studentDocumentMapper.selectDocument(id, name, 0));
    }

    @Override
    public Integer selectDocumentCount(String name) {
        return studentDocumentMapper.selectDocumentCount(FlagEnum.Upload.getCode(), name);
    }


}
