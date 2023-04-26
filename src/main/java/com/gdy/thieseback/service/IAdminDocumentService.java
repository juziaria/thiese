package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface IAdminDocumentService extends IService<Admin> {
    /**
     * 上传文件
     */
    Boolean uploadDocument(Document document);
    /**
     * 下载文件
     */
    Boolean downloadDocument(String saveDirPath, Integer id);
    /**
     * 删除文件
     */
    Boolean deleteDocument(Integer id);
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
