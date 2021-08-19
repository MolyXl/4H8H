package com.shbh.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 投票
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("article_vote")
public class ArticleVote implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 投票时间
     */
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ArticleVote{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", userId=" + userId +
        ", createTime=" + createTime +
        "}";
    }
}
