package com.bit2016.mysite.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2016.mysite.service.BoardService;
import com.bit2016.mysite.vo.BoardVo;
import com.bit2016.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController<boardVo> {
	
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
	
	@RequestMapping("/writeform")
	public String writeform() {
		return "board/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String insert(HttpSession session, @ModelAttribute BoardVo vo ) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if( authUser == null) {
			return "redirect:/user/loginform";
		}
		System.out.println(vo);
		boardService.insert(vo);
		return "redirect:/board";
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
