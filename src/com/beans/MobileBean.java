package com.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mobile")
public class MobileBean {
	
	@Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private int prodId;
	private String modelMake;
	private String modelName;
	private int price;
	private String imgPath;
	private boolean availability;
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getModelMake() {
		return modelMake;
	}
	public void setModelMake(String modelMake) {
		this.modelMake = modelMake;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	@Override
	public String toString() {
		return "MobileBean [prodId=" + prodId + ", modelMake=" + modelMake
				+ ", modelName=" + modelName + ", price=" + price
				+ ", imgPath=" + imgPath + ", availability=" + availability
				+ "]";
	}
	
}
