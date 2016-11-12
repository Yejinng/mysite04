package com.bit2016.mysite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2016.mysite.service.BoardService;
import com.bit2016.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String index(
			@RequestParam(value="p", required=true, defaultValue="1") Integer page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword,
			Model model) {
		
		Map<String, Object> map = boardService.getList( page, keyword );
		
		model.addAttribute( "map", map );
		
		return "board/list";
	}
	
	@RequestMapping("view")
	public String view(
			@RequestParam(value="no", required=true, defaultValue="0") Long no,
			@RequestParam(value="p", required=true, defaultValue="1") Integer page,
			Model model){
		
		BoardVo boardVo = boardService.view(no);
		boardService.updateHit(no);
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("page", page);
		System.out.println(boardVo + ":" + page);
		return "board/view";
	}
}
