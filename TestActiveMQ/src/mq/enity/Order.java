package mq.enity;

import java.io.Serializable;

public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -343247274477730446L;
	private Integer id;//订单id
	private Double amount;
	private Integer goodsId;//商品id
	private Integer goodsAmount;//商品数量
	private Integer shopId;//店铺名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(Integer goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String toString(){
		return "订单id："+this.id+","+"金额（元）："+this.amount+","+"商品id:"+
	          this.shopId+","+"商品数量："+this.goodsAmount+","+"店铺id："+this.shopId;
	}
	
}
