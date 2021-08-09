package com.shbh.sentinel.thirdPart;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MaZhuli
 * @version 1.0.0
 * @package com.shbh.sentinel.thirdPart description
 * @since 2021/4/6
 */
public class BaiDuSpeech {
    //设置APPID/AK/SK
    public static final String APP_ID = "23935819";
    public static final String API_KEY = "sqeGKSBn8grZFZrKvNQe6W4o";
    public static final String SECRET_KEY = "WhcKauWnCeBlmYwV02Nv4fki8pFO1C1E";
    public static JSONObject ptSpeech(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, Object> options = new HashMap<>();
        //options.put("dev_pid", 1737);
        //1537	普通话(纯中文识别)	输入法模型	有标点	支持自定义词库
        //1737	英语		无标点	不支持自定义词库
        //1637	粤语		有标点	不支持自定义词库
        //1837	四川话		有标点	不支持自定义词库
        //1936	普通话远场	远场模型	有标点	不支持
        InputStream inputStream = file.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        while ((len = inputStream.read(data)) != -1) {
            byteArrayOutputStream.write(data, 0, len);
        }
        JSONObject res = client.asr(data, "wav", 16000, options);
        System.out.println(res.toString(2));
        return res;
    }
    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.properties.conf", "path/to/your/log4j.properties.properties");

        // 调用接口
        HashMap<String, Object> options = new HashMap<>();
        options.put("dev_pid", 1737);
        //1537	普通话(纯中文识别)	输入法模型	有标点	支持自定义词库
        //1737	英语		无标点	不支持自定义词库
        //1637	粤语		有标点	不支持自定义词库
        //1837	四川话		有标点	不支持自定义词库
        //1936	普通话远场	远场模型	有标点	不支持
        JSONObject res = client.asr("D:\\mysource\\4H8H\\user\\src\\main\\resources\\06954d74-193a-4c30-98d7-e98d3b2f3393.wav", "wav", 16000, options);
        System.out.println(res.toString(2));

    }
}
