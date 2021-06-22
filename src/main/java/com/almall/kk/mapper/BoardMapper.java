package com.almall.kk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.almall.kk.vo.FreeBoardVO;

@Mapper
@Repository
public interface BoardMapper {

	int writeBoard(FreeBoardVO freeBoardVO);

	List<FreeBoardVO> getFreeBoard(FreeBoardVO freeBoardVO);

	int getFreeBoardTotalCnt(FreeBoardVO freeBoardVO);

	FreeBoardVO findByNo(@Param("boardNo") int boardNo);

	int updateBoard(FreeBoardVO freeBoardVO);

	int deleteBoard(@Param("boardNo") int boardNo);
}
