package com.beans;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="karts")
public class KartBean {
	
	@Id
	private String kartId;
		
	private int noOfProducts=0;
	private ArrayList<Integer> products = new ArrayList<>();
	
	public ArrayList<Integer> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Integer> products) {
		this.products = products;
	}
	public String getKartId() {
		return kartId;
	}
	public void setKartId(String kartId) {
		this.kartId = kartId;
	}
		
	public int getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	
}
