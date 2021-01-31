package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.SignupBean;
import com.dao.Signupdao;

@CrossOrigin
@RestController
public class SignupController {
	@Autowired
	Signupdao dao;
	
	@PostMapping("signup")
	public ResponseBean<SignupBean> signup(@RequestBody SignupBean signUpBean)
	{
		ResponseBean<SignupBean> response=new ResponseBean<>();
		dao.signupUser(signUpBean);
		
		response.setData(signUpBean);
		response.setMsg("User SignUp....");
		response.setStatus(200);
		
		return response;
	}
	
	@GetMapping("ListUser")
	public ResponseBean<List<SignupBean>> listUser()
	{
		ResponseBean<List<SignupBean>> response= new ResponseBean<>();
			List<SignupBean> bean=null;
			bean=dao.showusers(bean);
			
			response.setData(bean);
			response.setMsg("Users...");
			response.setStatus(200);
		
		
		return response;
		
	}
	
	@DeleteMapping("deleteuser/{userid}")
	public ResponseBean<SignupBean> deleteuser(@PathVariable("userid") int userid)
	{
		ResponseBean<SignupBean> response = new ResponseBean<>();
				SignupBean bean =null;
				bean=dao.deleteuser(userid);
				
				response.setData(bean);
				if(bean != null)
				{
					response.setMsg("User Deleted");
				}else
				{
					response.setMsg("User Not Found...");
				}
				response.setStatus(200);
			
			return response;
	}
	
	@PutMapping("updateuser")
	public ResponseBean<SignupBean> updateUser(@RequestBody SignupBean signupBean)
	{
		ResponseBean<SignupBean> response = new ResponseBean<>();
		dao.updateUser(signupBean);
		response.setData(signupBean);
		response.setMsg("User Updated");
		response.setStatus(200);
		return response;
	}
	
	@PostMapping("login")
	public ResponseBean<SignupBean> login(@RequestBody LoginBean login)
	{
		SignupBean bean=null;
		ResponseBean<SignupBean> response= new ResponseBean<>();
		bean=dao.login(login.getEmail(),login.getPassword());
		response.setData(bean);
		response.setMsg("User Login");
		response.setStatus(200);
		return response;
	}
	
	

}
