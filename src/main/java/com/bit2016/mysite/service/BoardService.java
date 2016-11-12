package com.bit2016.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.mysite.repository.BoardDao;
import com.bit2016.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	private static final int LIST_SIZE = 5;
	private static final int PAGE_SIZE = 5;
	
	@Autowired
	private BoardDao boardDao;
	
	public BoardVo view(Long boardNo) {
		System.out.println(boardDao.view(boardNo));
		return boardDao.view(boardNo);
	}
	
	public void updateHit(Long boardNo) {
		boardDao.updateHit(boardNo);
	}

	public Map<String, Object> getList(Integer currentPage, String keyword ) {
		
		
		int totalCount = boardDao.TotalCount();
		int pageCount = (int) Math.ceil((double)totalCount / LIST_SIZE);
		int totalBlock = (int)((pageCount - 1)/PAGE_SIZE + 1);
		int currentBlock = (int)((currentPage - 1)/PAGE_SIZE + 1);
		int endPage = (int)((PAGE_SIZE * currentBlock));
		int startPage = (int)(endPage - (PAGE_SIZE - 1));
		int nextPage = (int)((currentBlock  *PAGE_SIZE) +1);
		int prevPage = (int)((currentBlock -1)* PAGE_SIZE);
		
		List<BoardVo> list = boardDao.getList(keyword, currentPage, LIST_SIZE);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("currentPage", currentPage);
		map.put("totalCount", totalCount);
		map.put("pageCount", pageCount);
		map.put("totalBlock", totalBlock);
		map.put("currentBlock", currentBlock);
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		map.put("nextPage", nextPage);
		map.put("prevPage", prevPage);
		map.put("listSize", LIST_SIZE);
		map.put("list", list);
		
		return map;
	}
	
}
