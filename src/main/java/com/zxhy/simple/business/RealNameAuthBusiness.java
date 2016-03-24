package com.zxhy.simple.business;

public interface RealNameAuthBusiness {
	
	/**
	 * 注册
	 * @param phone
	 * @param passwd
	 */
	public void register(String phone, String passwd);
	/**
	 * 登陆
	 * @param phone
	 * @param passwd
	 * @return
	 */
	public boolean logon(String phone, String passwd);
	/**
	 * 补充完成注册流程
	 * @param phone
	 * @param taskId
	 */
	public void checkRegister(String phone, String taskId);
	/**
	 * 核名
	 * @param phone
	 * @param idCode
	 * @param idName
	 */
	public void checkRealName(String phone, String idCode, String idName, String taskId);
	/**
	 * 刷脸
	 * @param phone
	 * @param face
	 */
	public void checkFace(String phone, String face, String taskId);
	/**
	 * 实名认证是否完成
	 * @param phone
	 * @return
	 */
	public boolean realNameAuthFinish(String phone);
	/**
	 * 得到实名认证任务信息
	 * @param phone
	 * @return
	 */
	public RealNameAuthTask getRealNameAuthTask(String phone);
	
	
}
