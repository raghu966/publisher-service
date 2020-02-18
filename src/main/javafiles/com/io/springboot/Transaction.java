package com.io.springboot;

public class Transaction {
	private int orderID;
	private int itemId;
	private int orderQty;
	private String region;

	public Transaction() {

	}

	public Transaction(int orderID, int itemId, int orderQty, String region) {
		super();
		this.orderID = orderID;
		this.itemId = itemId;
		this.orderQty = orderQty;
		this.region = region;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
