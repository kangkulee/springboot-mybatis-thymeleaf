package com.almall.kk.vo;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class UserVO {

	private int user_no;
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_addr;
	private String user_phone;
	private String user_email;
	private RoleType user_role;
	private Timestamp create_at;
}
