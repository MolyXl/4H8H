package com.shbh.users.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author MaZhuli
 * @since 2021-08-18
 */
@TableName("user_reward")
public class UserReward implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

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

    /**
     * 打赏总额
     */
    private BigDecimal payTotal;

    /**
     * 支付密码
     */
    private String payPwd;


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

    public BigDecimal getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(BigDecimal payTotal) {
        this.payTotal = payTotal;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    @Override
    public String toString() {
        return "UserReward{" +
        "id=" + id +
        ", userId=" + userId +
        ", rewardTotal=" + rewardTotal +
        ", settled=" + settled +
        ", unSettled=" + unSettled +
        ", payTotal=" + payTotal +
        ", payPwd=" + payPwd +
        "}";
    }
}
