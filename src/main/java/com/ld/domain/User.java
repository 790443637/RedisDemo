package com.ld.domain;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("User")
public class User {
	
	private Long id;
	private String name;
	private String email;
	private Integer age;
	private Date bornDate;
	
	public User() {
	}
	public User(String name, String email, Integer age, Date bornDate) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.bornDate = bornDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", age=" + age + ", bornDate=" + bornDate + "]";
	}
}
