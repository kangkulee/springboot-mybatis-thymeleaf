package com.almall.kk.paging;

import lombok.Data;

@Data
public class PageHandler {
	private int totalCnt; // 전체 페이지 개수
	private int pageNum; // 현재 페이지 번호
	private int contentNum; // 1블록당 몇개의 게시물 표시할지
	private int startPage; //블록의 시작페이지
	private int endPage; // 블로의 마지막 페이지
	private boolean prevPage; // 이전페이지 유무
	private boolean nextPage; // 다음파에지 유무
	private int currentPage; // 현재 페이지
	private int lastPage; // 마지막 페이지
	private int pageBlockCnt=5; // 몇개의 페이지를 나눠 줄건지 표시 (contentNum이 10이라면 10개씩 5 페이지)
	
	//이전페이지 와 다음페이지 유무를 계산
	public void prevOrNext(int pageNum) {
		if(pageNum > 0 && pageNum <=pageBlockCnt && getLastPage() <= 1) {
			setPrevPage(false);
			setNextPage(false);
		} else if (pageNum > 0 && pageNum <= pageBlockCnt) {
			setPrevPage(false);
			setNextPage(true);
		} else if (getLastPage() == getCurrentPage()) {
			setPrevPage(true);
			setNextPage(false);
		} else {
			setPrevPage(true);
			setNextPage(true);
		}
	}
	
	//총 보여줄 페이지 수
	public int calcPage(int totalCnt, int contentNum) {
		
		//totalCnt가 125개 이고  contentNum이  10이라고 가정하면, 125나누기 10 = 12.5 
		//12.5 에서 10을 나눴을때 나머지값이 0보다 크기 때문에 한페이지 더 ++ 해주면 총 13페이지
		int totalPage = totalCnt/contentNum;
		if(totalCnt%contentNum > 0 ) {
			totalPage++;
		}
		return totalPage;
	}
	
	//시작 페이지 구하기
	public void setStartPage(int currentPage) {
		this.startPage = (currentPage*pageBlockCnt) -(pageBlockCnt-1);
	}
	
	//마지막 페이지 구하기 위해 calcPage 함수 이용
	public void setEndPage(int getLastPage, int getCurrentPage) {
		if(getLastPage == getCurrentPage) {
			this.endPage = calcPage(getTotalCnt(), getContentNum());
		} else {
			this.endPage = getStartPage()+(getPageBlockCnt()-1);
		}
	}
	
	//페이지 번호를 통해서 현재페이지 위치 구하기
	public void setCurrentPage(int pageNum) {
		//pageNum=1 pageBlockCnt= 5
		//1/5 = 0.2 -> if 거쳐서 +1 되어 1.2 가 되며 1 1페이지가 됨
		//pageNum=6 이라면 6/5 = 1.2 if 거친후 + 1 되어 2페이지가 됨
		this.currentPage = pageNum/pageBlockCnt;
		if(pageNum%pageBlockCnt > 0) {
			this.currentPage++;
		}
	}
	//마지막페이지 위치 구하기
	public void setLastPage(int totalCnt) {
		// 1~5페이지 까지 있을때 1페이지당 contentNum이 10 이라면
		// totalCnt가125일때 125/50 = 2.5 임으로 if 거친후 3이됨
		this.lastPage = totalCnt / (pageBlockCnt*this.contentNum);
		if(totalCnt % (pageBlockCnt*this.contentNum) > 0) {
			this.lastPage++;
		}
	}
}
