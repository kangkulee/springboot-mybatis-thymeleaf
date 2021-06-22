package com.almall.kk.vo;

import lombok.Data;

@Data
public class PagingVO {
	private int limitCnt;
	private int contentNum;
    private int pageNum;
    private String search; //like 에 쓰는 필드
    private String orderBy; // 내림차순 오름차순 보는 옵션 이용시 사용
    private String column; //where 에 쓰는 필드 searchType 이라고 생각하면 된다.
}
