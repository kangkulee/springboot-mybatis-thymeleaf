/*
 * package pro.cntech.car.controller;
 * 
 * import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import pro.cntech.car.service.HistoryService; import pro.cntech.car.vo.CarVO;
 * import pro.cntech.car.vo.HistoryVO;
 * 
 * 운행 이력 조회
 * 
 * @Controller public class HistoryController {
 * 
 * @Autowired HistoryService historyService;
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(HistoryController.class);
 * 
 * //운행 이력 조회 페이지 이동
 * 
 * @GetMapping("/history/{search}/list/{page}") public String
 * loadCarsHistoryPage(ModelMap model,
 * 
 * @PathVariable("search") String search,
 * 
 * @PathVariable("page") int page) {
 * logger.debug("/history/"+search+"/list/"+page+""); HistoryVO historyVO = new
 * HistoryVO(); historyVO.setPageNum(page); historyVO.setSearch(search);
 * historyService.getHistoryList(historyVO, model); return "oper_history"; }
 * 
 * //검색을 위한 전체리스트
 * 
 * @PostMapping("/ajax/history/list")
 * 
 * @ResponseBody public List<HistoryVO> historyList(ModelMap model) { HistoryVO
 * historyVO = new HistoryVO(); return
 * historyService.getSearchHistoryList(historyVO); }
 * 
 * //검색용 리스트
 * 
 * @GetMapping("/history/{column}/{search}/list/{page}") public String
 * searchCarsHistoryPage(ModelMap model,
 * 
 * @PathVariable("column") String column,
 * 
 * @PathVariable("search") String search,
 * 
 * @PathVariable("page") int page ) {
 * logger.debug("/history/"+column+"/"+search+"/list/"+page+""); HistoryVO
 * historyVO = new HistoryVO(); historyVO.setPageNum(page);
 * historyVO.setSearch(search); historyVO.setColumn(column);
 * historyService.getHistoryList(historyVO, model); return "oper_history"; } }
 */