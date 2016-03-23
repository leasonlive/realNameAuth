package com.zxhy.simple.service;
/**
 * 实名认证服务接口
 * @author leasonlive
 *
 */
public interface RealNameAuthService {
	/**
	 * 注册
	 * @param phone
	 * @param passwd
	 */
	public void register(String phone, String passwd);
	public void updateRealName(String phone, String idCode, String idName);
	public void updatePhoto(String phone, String photoUrl);
	public void updateFace(String phone, String faceUrl);
	public void delete(String phone);
}
