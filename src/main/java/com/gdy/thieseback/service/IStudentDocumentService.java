package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.DocumentInfo;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Document;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentDocumentService extends IService<Document> {
    /**
     * 下载文件
     */
    Boolean downloadDocument(String saveDirPath, Integer id);
    /**
     * 文件查询
     */
    List<DocumentInfo> showDocuments(String name);
    Document selectDocument(Integer id, String name);
    /**
     * 文件数量查询
     */
    Integer selectDocumentCount(String name);

}
