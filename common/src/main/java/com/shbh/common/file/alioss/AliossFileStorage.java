package com.shbh.common.file.alioss;

import com.aliyun.oss.OSSClient;
import com.shbh.common.file.FileMeta;
import com.shbh.common.file.FileStorageCondition;
import com.shbh.common.file.FileUtil;
import com.shbh.common.file.IFileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component("alioss")
@Conditional(FileStorageCondition.class)
public class AliossFileStorage implements IFileStorage {
    @Autowired
    AliossConfig config;
    @Override
    public FileMeta put(MultipartFile file) {
        try {
            return put(file.getInputStream(),file.getOriginalFilename(),file.getContentType(),file.getSize());
        }catch(Exception ex){
            return null;
        }

    }

    @Override
    public FileMeta put(byte[] data,String fileName,String mimeType) {
        InputStream stream = new ByteArrayInputStream(data);
        return put(stream,fileName,mimeType,Long.parseLong(String.valueOf(data.length)));
    }

    @Override
    public FileMeta put(InputStream stream,String fileName,String mimeType,Long size) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String fileDir = format.format(new Date());
        OSSClient client = new OSSClient(config.getEndpoint(), config.getAccessKeyId(),config.getAccessKeySecret());

        String newfileName = UUID.randomUUID().toString().replaceAll("-", "") + fileName.substring(fileName.lastIndexOf("."));
        // 上传文件
        try {
            String buketname = config.getBuketname(FileUtil.getFileType(newfileName));
            client.putObject(buketname, fileDir +"/"+ newfileName, stream);

            FileMeta meta=new FileMeta();
            meta.setName(fileName);
            meta.setPath("http://" + buketname + config.getEndpoint().replace("http://",".") + "/"+ fileDir + "/" + newfileName);
            meta.setSize(size);
            meta.setMimeType(mimeType);
            return meta;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            client.shutdown();
        }
        return  null;
    }

    @Override
    public boolean delete(String path) {
        return false;
    }
}