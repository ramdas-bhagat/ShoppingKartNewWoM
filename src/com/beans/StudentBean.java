package com.beans;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studDOB"})
@JsonPropertyOrder({"studNo", "studName"})*/
//@Entity
@Component
public class StudentBean{
	/*@Id
	@JsonProperty("Student_Name")*/
	private String studName;
	
	/*@JsonProperty("Student_ID")*/
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
