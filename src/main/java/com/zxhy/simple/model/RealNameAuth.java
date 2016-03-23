package com.zxhy.simple.model;
/**
 * 实名认证
 * @author leasonlive
 *
 */
public class RealNameAuth {
	private String phone;
	private String passwd;
	private String idCode;
	private String idName;
	private String idPhotoUrl;
	private String faceUrl;
	public RealNameAuth() {
	}
	public RealNameAuth(String phone, String passwd, String idCode, String idName, String idPhotoUrl, String faceUrl) {
		this.phone = phone;
		this.passwd = passwd;
		this.idCode = idCode;
		this.idName = idName;
		this.idPhotoUrl = idPhotoUrl;
		this.faceUrl = faceUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	public String getIdPhotoUrl() {
		return idPhotoUrl;
	}
	public void setIdPhotoUrl(String idPhotoUrl) {
		this.idPhotoUrl = idPhotoUrl;
	}
	public String getFaceUrl() {
		return faceUrl;
	}
	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
	}
	
}
