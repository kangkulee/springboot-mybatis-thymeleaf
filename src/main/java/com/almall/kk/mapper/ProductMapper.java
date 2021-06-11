package com.almall.kk.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.almall.kk.vo.ProductVO;

@Mapper
@Repository
public interface ProductMapper {
	ArrayList<ProductVO> findByProducts();
	
	ProductVO findByProductNo(@Param("productNo") int productNo);
}
