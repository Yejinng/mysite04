package com.bit2016.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2016.mysite.service.GuestbookService;
import com.bit2016.mysite.vo.GuestbookVo;
import com.bit2016.mysite.vo.UserVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookService.getList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert( HttpSession session, @ModelAttribute GuestbookVo vo ) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		//접근제한
		if( authUser == null) {
			return "redirect:/user/loginform";
		}
		guestbookService.insert(vo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(HttpSession session, @PathVariable("no") int no, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		//접근제한
		if( authUser == null) {
			return "redirect:/user/loginform";
		}
		model.addAttribute("no", no);
		return "/guestbook/deleteform";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpSession session, @ModelAttribute GuestbookVo vo) {
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		//접근제한
		if( authUser == null) {
			return "redirect:/user/loginform";
		}
		System.out.println(vo);
		guestbookService.delete(vo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/ajax")
	public String ajax(){
		return "guestbook/list-ajax";
	}

}
