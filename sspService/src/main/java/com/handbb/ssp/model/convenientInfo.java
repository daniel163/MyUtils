package com.handbb.ssp.model;


public class convenientInfo {
	
	private String convenientId;
	private String convenientDes;
	
	public String getConvenientId() {
		return convenientId;
	}
	public void setConvenientId(String convenientId) {
		this.convenientId = convenientId;
	}
	public String getConvenientDes() {
		return convenientDes;
	}
	public void setConvenientDes(String convenientDes) {
		this.convenientDes = convenientDes;
	}
	
	@Override
	public String toString() {
		return "convenientInfo [convenientId=" + convenientId
				+ ", convenientDes=" + convenientDes + "]";
	}
	
	
	
	
}
