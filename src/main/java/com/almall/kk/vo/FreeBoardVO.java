package com.almall.kk.vo;

import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FreeBoardVO extends PagingVO {
	private int freeboard_no;
	private int user_no;
	private String user_id;
	private String freeboard_title;
	private String freeboard_content;
	private Timestamp create_at;
}
