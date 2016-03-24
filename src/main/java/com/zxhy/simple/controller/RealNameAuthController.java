package com.zxhy.simple.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxhy.simple.business.RealNameAuthBusiness;
import com.zxhy.simple.business.RealNameAuthTask;
import com.zxhy.simple.model.RealNameAuth;

@Controller
@RequestMapping("/realNameAuth")
public class RealNameAuthController {
	private static final Log log = LogFactory.getLog(RealNameAuthController.class);
	@Autowired
	private RealNameAuthBusiness realNameAuthBusiness;
	@ResponseBody
	@RequestMapping("/logon")
	public RealNameAuthTask logon(@RequestParam(name="phone") String phone, @RequestParam(name="passwd") String passwd){
		log.debug("logon phone:" + phone + " passwd:" + passwd);
		boolean logon = this.realNameAuthBusiness.logon(phone, passwd);
		if (logon){
			RealNameAuthTask task = this.realNameAuthBusiness.getRealNameAuthTask(phone);
			if (task == null){
				return new RealNameAuthTask();
			} else {
				return task;
			}
		} else {
			return new RealNameAuthTask();
		}
	}
	@ResponseBody
	@RequestMapping("/register")
	public RealNameAuthTask register(@RequestParam(name="phone") String phone, @RequestParam(name="passwd") String passwd){
		log.debug("logon phone:" + phone + " passwd:" + passwd);
		this.realNameAuthBusiness.register(phone, passwd);
		return this.realNameAuthBusiness.getRealNameAuthTask(phone);
	}
	@ResponseBody
	@RequestMapping("/finishTask")
	public RealNameAuthTask finishTask(
			@RequestParam(name="phone") String phone, 
			@RequestParam(name="passwd") String passwd,
			@RequestParam(name="taskName") String taskName,
			@RequestParam(name="taskId") String taskId){
		log.debug("logon phone:" + phone + " passwd:" + passwd + " taskName:" + taskName + " taskId:" + taskId);
		if ("注册".equals(taskName)){
			this.realNameAuthBusiness.checkRegister(phone, taskId);
		} else if ("核名".equals(taskName)){
			this.realNameAuthBusiness.checkRealName(phone, "身份号码123", "姓名123", taskId);
		} else if ("刷脸".equals(taskName)){
			this.realNameAuthBusiness.checkFace(phone, "刷脸123", taskId);
		}
		RealNameAuthTask task =  this.realNameAuthBusiness.getRealNameAuthTask(phone);
		if (task == null){
			return new RealNameAuthTask();
		} else {
			return task;
		}
	}
	
}
