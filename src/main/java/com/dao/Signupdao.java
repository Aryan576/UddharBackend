package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SignupBean;

@Repository
public class Signupdao {
	@Autowired
	JdbcTemplate stmt;

	public void signupUser(SignupBean signUpBean) {
		// TODO Auto-generated method stub

		stmt.update(
				"insert into signup (firstname,lastname,email,password,gender,age,mobileno,address) values(?,?,?,?,?,?,?,?)",
				signUpBean.getFirstname(), signUpBean.getLastname(), signUpBean.getEmail(), signUpBean.getPassword(),
				signUpBean.getGender(), signUpBean.getAge(), signUpBean.getMobileno(), signUpBean.getAddress());

	}

	public List<SignupBean> showusers(List<SignupBean> bean) {
		// TODO Auto-generated method stub

		bean = stmt.query("select * from signup", BeanPropertyRowMapper.newInstance(SignupBean.class));

		return bean;
	}

	public SignupBean deleteuser(int userid) {
		// TODO Auto-generated method stub
		SignupBean bean = null;
		bean = getUserById(userid);
		if (bean != null) {
			stmt.update("delete from signup where userid=?", userid);
		}
		return bean;
	}


	private SignupBean getUserById(int userid) {
		// TODO Auto-generated method stub
		SignupBean bean = null;
		try {
			bean = stmt.queryForObject("select * from signup where userid = ?",BeanPropertyRowMapper.newInstance(SignupBean.class),new Object[] { userid });
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}

	public void updateUser(SignupBean signupBean) {
		// TODO Auto-generated method stub

		stmt.update(
				"update signup set firstname=?,lastname=?,email=?,password=?,gender=?,age=?,mobileno=?,address=? where userid=?",
				signupBean.getFirstname(), signupBean.getLastname(), signupBean.getEmail(), signupBean.getPassword(),
				signupBean.getGender(), signupBean.getAge(), signupBean.getMobileno(), signupBean.getAddress(),
				signupBean.getUserid());

	}

	public SignupBean login(String email, String password) {
		// TODO Auto-generated method stub
		SignupBean bean = null;
		try {
			bean = stmt.queryForObject("select * from signup where email=? and password=?",
					BeanPropertyRowMapper.newInstance(SignupBean.class),new Object[] { email, password });
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}

}
