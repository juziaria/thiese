package com.gdy.thieseback.entity;

import com.gdy.thieseback.util.MyPath;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import com.gdy.thieseback.myEnum.*;
import java.io.*;
import java.util.Date;

@Data
public class Document {
    @ApiModelProperty(value = "主键")
    private int id;

    @ApiModelProperty(value = "文件类型，即拓展名")
    private String extension;

    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "上传时间")
    private Date uploadTime;

    @ApiModelProperty(value = "文件大小")
    private long size;

    @ApiModelProperty(value = "删除标志")
    private int flag;


    public Document(){}

    @Autowired
    public Document(String content, String filename, String extension){
        this.content = content;
        this.name = filename;
        this.extension = extension;
    }

    @Autowired
    public Document(String content){
        this.content = content;
    }

    @Autowired
    public Document(File file){
        String[] fileName = file.getName().split("\\.");
        this.name = fileName[0];
        this.extension = fileName[fileName.length - 1];
        this.size = file.length();
        this.content = this.read(file);
        this.uploadTime = new Date();
        this.flag = FlagEnum.Upload.getCode();
    }

    public String read(File file){
        String result = "";
        try {
            if(file.exists() && file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = fis.read(buff)) != -1) {
                    bos.write(buff, 0, len);
                }

                byte[] bytes = bos.toByteArray();

                BASE64Encoder encoder = new BASE64Encoder();
                result = encoder.encode(bytes).trim();

                bos.close();
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Boolean save(String path){
        MyPath myPath = new MyPath(path);

        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(this.content);
            OutputStream os = new FileOutputStream(myPath.getPath());
            os.write(bytes, 0, bytes.length);
            os.flush();
            os.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getSavaPath(String dirPath){
        String path = String.format("%s\\\\%s.%s", dirPath, this.name, this.extension);
        MyPath myPath = new MyPath(path);
        return myPath.getPath();
    }

    public String getFileName(){
        return String.format("%s.%s",this.name,this.extension);
    }

}
