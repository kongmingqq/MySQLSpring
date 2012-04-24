package msi.domain;

import java.util.Date;
import java.util.List;

public class Subscription {
	private String userId;
	private List<String> userIds;
	private int installmentNumber;
	private boolean transmitted = false;
	private String updatedBy = "KM";
	private Date updatedTime = new Date();
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	public int getInstallmentNumber() {
		return installmentNumber;
	}
	public void setInstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}
	public boolean isTransmitted() {
		return transmitted;
	}
	public void setTransmitted(boolean transmitted) {
		this.transmitted = transmitted;
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
