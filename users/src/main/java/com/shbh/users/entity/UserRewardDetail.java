package com.shbh.users.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户赏金明细
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("user_reward_detail")
public class UserRewardDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 来源(1 文章 2 反馈)
     */
    private Boolean source;

    /**
     * 类型(1 收入 2 支出)
     */
    private Boolean type;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 反馈id
     */
    private Integer exchangeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Boolean getSource() {
        return source;
    }

    public void setSource(Boolean source) {
        this.source = source;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Override
    public String toString() {
        return "UserRewardDetail{" +
        "id=" + id +
        ", userId=" + userId +
        ", amount=" + amount +
        ", createTime=" + createTime +
        ", source=" + source +
        ", type=" + type +
        ", articleId=" + articleId +
        ", exchangeId=" + exchangeId +
        "}";
    }
}
