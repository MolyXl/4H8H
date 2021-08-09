package com.shbh.common.file.alioss;

import com.shbh.common.file.FileType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliossConfig{
    @Value("${alioss.endpoint:}")
    private String endpoint;

    @Value("${alioss.accesskeyid:}")
    private String accessKeyId;

    @Value("${alioss.accesskeysecret:}")
    private String accessKeySecret;

    @Value("${alioss.imagebuketname:}")
    private String imageBuketName;

    @Value("${alioss.videobuketname:}")
    private String videoBuketName;

    @Value("${alioss.filebuketname:}")
    private String fileBuketName;

    public String getEndpoint(){
        return this.endpoint;
    }

    public String getAccessKeyId(){
        return this.accessKeyId;
    }

    public String getAccessKeySecret(){
        return this.accessKeySecret;
    }

    public String getImageBuketname(){
        return this.imageBuketName;
    }

    public String getVideoBuketname(){
        return this.videoBuketName;
    }

    public String getFileBuketname(){
        return this.fileBuketName;
    }

    public String getBuketname(FileType type){
        if(type.equals(FileType.IMAGE)){
            return this.imageBuketName;
        }else if (type.equals(FileType.VIDEO)) {
            return this.videoBuketName;
        }else{
            return this.fileBuketName;
        }
    }
}