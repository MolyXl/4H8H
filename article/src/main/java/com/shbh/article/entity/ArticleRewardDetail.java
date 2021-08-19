package com.shbh.article.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 文章赏金明细
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("article_reward_detail")
public class ArticleRewardDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 赏金金额
     */
    private BigDecimal amount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付方式
     */
    private Boolean payType;

    /**
     * 支付状态
     */
    private Boolean payStatus;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付人
     */
    private Integer payUserId;


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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getPayType() {
        return payType;
    }

    public void setPayType(Boolean payType) {
        this.payType = payType;
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Integer payUserId) {
        this.payUserId = payUserId;
    }

    @Override
    public String toString() {
        return "ArticleRewardDetail{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", amount=" + amount +
        ", createTime=" + createTime +
        ", payType=" + payType +
        ", payStatus=" + payStatus +
        ", payTime=" + payTime +
        ", payUserId=" + payUserId +
        "}";
    }
}
