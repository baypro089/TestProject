package com.magaki.mainFrame;

public class Orders {
	private String name;
	private int amount;
	private String unit;
	private long price;
	
	public Orders(String name, int amount, String unit, long price) {
		this.name = name;
		this.amount = amount;
		this.unit = unit;
		this.price = price;
	}
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	

}
