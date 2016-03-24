package com.zxhy.simple.business.impl;

import java.util.List;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zxhy.simple.business.RealNameAuthBusiness;
import com.zxhy.simple.business.RealNameAuthTask;
import com.zxhy.simple.model.RealNameAuth;
import com.zxhy.simple.service.RealNameAuthService;
import com.zxhy.support.workflow.ProcessEngine;
import com.zxhy.support.workflow.impl.TaskInfo;
@Component
public class RealNameAuthBusinessImpl implements RealNameAuthBusiness{
	private static final Log log = LogFactory.getLog(RealNameAuthBusinessImpl.class);
	private static final String ProcessDefinitionKey = "realNameAuth";
	@Autowired
	private RealNameAuthService realNameAuthService;
	@Autowired
	private ProcessEngine processEngine;
	public void register(String phone, String passwd) {
		this.realNameAuthService.register(phone, passwd);
		this.processEngine.addUser(phone, phone, phone, null, passwd);
		this.processEngine.addUserToGroup(phone, "realName");
		JSONArray json = new JSONArray();
		JSONObject businessKey = new JSONObject();
		businessKey.put("name", "businessKey");
		businessKey.put("value", phone);
		json.put(businessKey);
		//启动任务
		this.processEngine.startProcessByKey(ProcessDefinitionKey, phone, json);
		RealNameAuthTask task = this.getRealNameAuthTask(phone);
		//完成第一步注册，到核名环节
		this.processEngine.completeTask(task.getTaskId(), null);
	}

	public boolean logon(String phone, String passwd) {
		RealNameAuth realNameAuth = this.realNameAuthService.findByPhone(phone);
		if (realNameAuth == null){
			throw new RuntimeException("账户不存在");
		}
		if (!passwd.equals(realNameAuth.getPasswd())){
			throw new RuntimeException("密码号账户不匹配");
		}
		return true;
	}
	public void checkRegister(String phone, String taskId){
		this.processEngine.completeTask(taskId, null);
	}
	public void checkRealName(String phone, String idCode, String idName, String taskId) {
		this.realNameAuthService.updateRealName(phone, idCode, idName);
		this.processEngine.completeTask(taskId, null);
	}

	public void checkFace(String phone, String face, String taskId) {
		this.realNameAuthService.updateFace(phone, face);
		this.processEngine.completeTask(taskId, null);
		
	}

	public boolean realNameAuthFinish(String phone) {
		return this.getRealNameAuthTask(phone) == null;
	}

	public RealNameAuthTask getRealNameAuthTask(String phone) {
		List<TaskInfo> list = this.processEngine.getMyTask(phone, ProcessDefinitionKey);
		for (TaskInfo taskInfo : list) {
			log.debug("processDefinitionID:" + taskInfo.getProcessDefinitionId());
			RealNameAuthTask task = new RealNameAuthTask();
			task.setPhone(phone);
			task.setProcessName(taskInfo.getProcessDefinitionName());
			task.setTaskId(taskInfo.getTaskId());
			task.setTaskName(taskInfo.getName());
			return task;
		}
		return null;
	}
	
}
