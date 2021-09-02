package com.shbh.sentinel.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("admin_log")
public class AdminLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志内容
     */
    private String content;

    /**
     * 时间
     */
    private Date logTime;

    /**
     * 管理员id
     */
    private Integer adminId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "AdminLog{" +
        "id=" + id +
        ", type=" + type +
        ", content=" + content +
        ", logTime=" + logTime +
        ", adminId=" + adminId +
        "}";
    }
}
