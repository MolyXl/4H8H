package com.shbh.article.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 文章赏金
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("article_reward")
public class ArticleReward implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 获得总赏金
     */
    private BigDecimal rewardTotal;

    /**
     * 结算赏金
     */
    private BigDecimal settled;

    /**
     * 未结算赏金
     */
    private BigDecimal unSettled;


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

    public BigDecimal getRewardTotal() {
        return rewardTotal;
    }

    public void setRewardTotal(BigDecimal rewardTotal) {
        this.rewardTotal = rewardTotal;
    }

    public BigDecimal getSettled() {
        return settled;
    }

    public void setSettled(BigDecimal settled) {
        this.settled = settled;
    }

    public BigDecimal getUnSettled() {
        return unSettled;
    }

    public void setUnSettled(BigDecimal unSettled) {
        this.unSettled = unSettled;
    }

    @Override
    public String toString() {
        return "ArticleReward{" +
        "id=" + id +
        ", articleId=" + articleId +
        ", rewardTotal=" + rewardTotal +
        ", settled=" + settled +
        ", unSettled=" + unSettled +
        "}";
    }
}
