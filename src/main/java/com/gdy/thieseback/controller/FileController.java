package com.gdy.thieseback.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdy.thieseback.entity.Files;
import com.gdy.thieseback.mapper.FileMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;


@RestController
@RequestMapping("/gdy/stu/file")
@Api(tags = "文件处理")
public class FileController {
//    @Value("${files.upload.path}")
//    private String fileUploadPath;

    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Resource
    private FileMapper fileMapper;


    //上传
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Files upload(@RequestParam MultipartFile file) throws IOException {
        //保存到数据库
        String originalFilename = file.getOriginalFilename(); //文件名.jpg
        String type = FileUtil.extName(originalFilename);//.jpg
        long size = file.getSize();//大小
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size / 1024);

        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid + StrUtil.DOT + type; // 41b1076684904f9cb4a503fb028db94b.jpg
        File uploadFile = new File(fileUploadPath + fileUUID);
        saveFile.setUrl(fileUUID);
//        String md5 = SecureUtil.md5(uploadFile);
//        saveFile.setMd5(md5);
        saveFile.setUrl(fileUUID);
        fileMapper.insert(saveFile);

        //先存储到磁盘
        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }
        String url;
        file.transferTo(uploadFile);
        //获取文件的md5
        //使用m5 避免重复上传相同的文件
//        Files dbFiles = getFileByMD5(md5);
//        if (dbFiles != null) {
//            url = dbFiles.getUrl();
//            uploadFile.delete();
//        } else {
//            url = "http://localhost:8086/gdy/stu/file/" + fileUUID;
//        }
        return saveFile;

    }

    //下载
    @ApiOperation("文件下载")
    @GetMapping("/{fileId}")
    public void download(@PathVariable String fileId,
                         HttpServletResponse response) throws IOException {
        Files files = this.fileMapper.selectById(fileId);
        String url = files.getUrl();
        String fileUrl = "D:\\upload\\" + url;
        downloadPathFile(fileUrl,response,files.getName());
    }

    public String downloadPathFile(String path, HttpServletResponse response,String fileName) {
        //设置文件路径
        File file = new File(path);
        //获取文件名称
//        String fileName = file.getName();
        //判断文件是否存在
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                file.delete();
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

    public Files getFileByMD5(String md5) {
        QueryWrapper<Files> wrapper = new QueryWrapper<>();
        wrapper.eq("md5", md5);
        List<Files> filesList = fileMapper.selectList(wrapper);
        return filesList.size() == 0 ? null : filesList.get(0);
    }
}
