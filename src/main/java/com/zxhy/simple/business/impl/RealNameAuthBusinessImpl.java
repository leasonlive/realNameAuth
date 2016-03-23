package com.zxhy.simple.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zxhy.simple.business.RealNameAuthBusiness;
import com.zxhy.simple.service.RealNameAuthService;
import com.zxhy.support.workflow.ProcessEngine;
@Component
public class RealNameAuthBusinessImpl implements RealNameAuthBusiness{
	@Autowired
	private RealNameAuthService realNameAuthService;
	@Autowired
	private ProcessEngine processEngine;
	public void register(String phone, String passwd) {
		this.realNameAuthService.register(phone, passwd);
		this.processEngine.addUser(phone, phone, phone, null, passwd);
		this.processEngine.addUserToGroup(phone, "realName");
		this.processEngine.startProcess("realNameAuth", phone, null);
		//this.processEngine.getCandidaTask(userId)
	}

	public void checkRealName(String phone, String idCode, String idName) {
		// TODO Auto-generated method stub
		
	}

	public void checkFace(String phone, String face) {
		// TODO Auto-generated method stub
		
	}

	public boolean realNameAuthFinish(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
