package com.shbh.exchange.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import java.io.Serializable;

/**
 * <p>
 * 公告_反馈
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("exchange")
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private Blob content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否官方发布(0 否 1 是)
     */
    private Boolean isOfficial;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 是否官方选中(0 否 1 是)
     */
    private Boolean voted;

    /**
     * 是否官方奖励(0 否 1 是)
     */
    private Boolean rewarded;

    /**
     * 是否删除(0 否 1 是)
     */
    private Boolean delFlag;

    /**
     * 是否审核通过(0 否 1 是)
     */
    private Boolean passAudit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Boolean getVoted() {
        return voted;
    }

    public void setVoted(Boolean voted) {
        this.voted = voted;
    }

    public Boolean getRewarded() {
        return rewarded;
    }

    public void setRewarded(Boolean rewarded) {
        this.rewarded = rewarded;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getPassAudit() {
        return passAudit;
    }

    public void setPassAudit(Boolean passAudit) {
        this.passAudit = passAudit;
    }

    @Override
    public String toString() {
        return "Exchange{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", createTime=" + createTime +
        ", isOfficial=" + isOfficial +
        ", userId=" + userId +
        ", adminId=" + adminId +
        ", voted=" + voted +
        ", rewarded=" + rewarded +
        ", delFlag=" + delFlag +
        ", passAudit=" + passAudit +
        "}";
    }
}
