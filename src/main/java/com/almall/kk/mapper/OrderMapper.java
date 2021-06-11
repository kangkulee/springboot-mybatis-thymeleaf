package com.almall.kk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.almall.kk.vo.OrderVO;

@Mapper
@Repository
public interface OrderMapper {

	int setOrder(OrderVO orderVO);
	
}
