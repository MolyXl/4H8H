package com.shbh.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 文章
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 根id
     */
    private Integer rootId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 是否根节点(0 否 1 是)
     */
    private Boolean rootFlag;

    /**
     * 是否选中节点(0 否 1 是)
     */
    private Boolean voted;

    /**
     * 是否已完成(0 否 1 是)
     */
    private Boolean finished;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 选中时间
     */
    private Date voteTime;

    /**
     * 是否匿名(0 否 1 是)
     */
    private Boolean anonymous;

    /**
     * 是否删除(0 否 1 是)
     */
    private Boolean delFlag;

    /**
     * 是否审核通过(0 否 1 是)
     */
    private Boolean passAudit;

    /**
     * 深度
     */
    private Integer episode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getRootFlag() {
        return rootFlag;
    }

    public void setRootFlag(Boolean rootFlag) {
        this.rootFlag = rootFlag;
    }

    public Boolean getVoted() {
        return voted;
    }

    public void setVoted(Boolean voted) {
        this.voted = voted;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
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

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", rootId=" + rootId +
        ", userId=" + userId +
        ", rootFlag=" + rootFlag +
        ", voted=" + voted +
        ", finished=" + finished +
        ", createTime=" + createTime +
        ", voteTime=" + voteTime +
        ", anonymous=" + anonymous +
        ", delFlag=" + delFlag +
        ", passAudit=" + passAudit +
        ", episode=" + episode +
        "}";
    }
}
