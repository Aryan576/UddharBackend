package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ServiceBean;

@Repository
public class Servicedao {

	@Autowired
	JdbcTemplate stmt;

	public void addservice(ServiceBean bean) {
		// TODO Auto-generated method stub
		stmt.update("insert into service(username,animaltype,services,address,mobileno,problem) values(?,?,?,?,?,?)",
				bean.getUsername(), bean.getAnimaltype(), bean.getServices(), bean.getAddress(), bean.getMobileno(),
				bean.getProblem());

	}

	public List<ServiceBean> Listservice(List<ServiceBean> bean) {
		// TODO Auto-generated method stub
		bean = stmt.query("select * from service", BeanPropertyRowMapper.newInstance(ServiceBean.class));
		return bean;
	}

}
