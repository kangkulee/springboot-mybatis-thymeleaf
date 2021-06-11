package com.almall.kk.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PrincipalVO {
	private int user_no;
	private String user_name;
	private String user_id;
	private String user_password;
	private String user_role;
}
