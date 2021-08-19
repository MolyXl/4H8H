package com.shbh.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 匿名文章
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("article_anonymous")
public class ArticleAnonymous implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 作者
     */
    private String author;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 领取时间
     */
    private Date claimTime;


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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    @Override
    public String toString() {
        return "ArticleAnonymous{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", author=" + author +
        ", pwd=" + pwd +
        ", claimTime=" + claimTime +
        "}";
    }
}
