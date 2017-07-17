package com.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="karts")
public class KartBean {
	
	@Id
	private String kartId;
	@OneToOne(mappedBy="kart")
	private UserBean user;
	
	private int noOfProducts=0;
	
	public String getKartId() {
		return kartId;
	}
	public void setKartId(String kartId) {
		this.kartId = kartId;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	
	public int getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	@Override
	public String toString() {
		return "KartBean [kartId=" + kartId + ", user=" + user + ", noOfProducts="
				+ noOfProducts + "]";
	}
}
