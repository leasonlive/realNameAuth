package com.zxhy.simple.business;

public interface RealNameAuthBusiness {
	/**
	 * 注册
	 * @param phone
	 * @param passwd
	 */
	public void register(String phone, String passwd);
	/**
	 * 核名
	 * @param phone
	 * @param idCode
	 * @param idName
	 */
	public void checkRealName(String phone, String idCode, String idName);
	/**
	 * 刷脸
	 * @param phone
	 * @param face
	 */
	public void checkFace(String phone, String face);
	/**
	 *
	 * @param phone
	 * @return
	 */
	public boolean realNameAuthFinish(String phone);
}
