package com.yedam.app.user.service;

import java.util.Date;

import lombok.Data;

@Data
public class UserVO {
	private String name;
	private Integer age;
	private Date today;
}
