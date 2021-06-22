package com.almall.kk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.almall.kk.vo.OrderVO;

@Mapper
@Repository
public interface OrderMapper {

	int setOrder(OrderVO orderVO);

	List<OrderVO> getOrderList(@Param("userNo") int user_no);

	int getOrderListTotalCnt(@Param("userNo") int user_no);
	
}
