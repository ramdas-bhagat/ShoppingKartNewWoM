package com.beans;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studDOB"})
@JsonPropertyOrder({"studNo", "studName"})
public class StudentBean{
	
	@JsonProperty("Student_Name")
	private String studName;
	
	@JsonProperty("Student_ID")
	private int studNo;
	
	private Date studDOB;
	
	public Date getStudDOB() {
		return studDOB;
	}

	public void setStudDOB(Date studDOB) {
		this.studDOB = studDOB;
	}

	public int getStudNo() {
		return studNo;
	}

	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	@Override
	public String toString() {
		return "StudentBean [studName=" + studName + ", studNo=" + studNo
				+ ", studDOB=" + studDOB + "]";
	}

}
