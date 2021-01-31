package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.ServiceBean;
import com.dao.Servicedao;

@CrossOrigin
@RestController
public class ServiceController {
	@Autowired
	Servicedao dao;
	
	@PostMapping("service")
	public ResponseBean<ServiceBean> service(@RequestBody ServiceBean bean)
	{
		ResponseBean<ServiceBean> response =new ResponseBean<>();
			dao.addservice(bean);
		response.setData(bean);
		response.setMsg("Service Booked");
		response.setStatus(200);
		
		return response;
	}
	@GetMapping("listservice")
	public ResponseBean<List<ServiceBean>> listservice()
	{	
		ResponseBean<List<ServiceBean>> response =new ResponseBean<>();
		List<ServiceBean> bean=null;
		bean=dao.Listservice(bean);
		
		response.setData(bean);
		response.setMsg("Services Register");
		response.setStatus(200);
		
		return response;
	}
	
	
	

}
