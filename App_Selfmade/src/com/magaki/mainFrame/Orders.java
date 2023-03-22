package com.magaki.mainFrame;

public class Orders {
	private String id;
	private String status;
	private String date;
	private long totalPrice;
	
	public Orders(String id, String status, String date, long totalPrice) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
