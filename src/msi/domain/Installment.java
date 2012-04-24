package msi.domain;

import java.util.Date;

public class Installment {
	private int installmentNumber;
	private String installmentContent;
	private String updatedBy = "KM";
	private Date updatedTime = new Date();
	
	public int getInstallmentNumber() {
		return installmentNumber;
	}
	public void setInstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}
	public String getInstallmentContent() {
		return installmentContent;
	}
	public void setInstallmentContent(String installmentContent) {
		this.installmentContent = installmentContent;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
}
