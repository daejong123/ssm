package com.daejong.vip.entity;

/**
 * Created by DaeJong on 2017/4/13.
 */
public class VipRankEntity {

    private String no;
    private String name;
    private String needAmount;
    private String remark;
    private String discount;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(String needAmount) {
        this.needAmount = needAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "VipRankEntity{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", needAmount='" + needAmount + '\'' +
                ", remark='" + remark + '\'' +
                ", discount=" + discount +
                '}';
    }
}
