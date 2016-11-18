package com.bit2016.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.mysite.service.GalleryService;
import com.bit2016.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GallleryController {

	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GalleryVo> list = galleryService.getList();
		model.addAttribute("list", list);
		model.addAttribute("url", GalleryService.URL );
		return "gallery/index";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "gallery/form";
	}
	
	@RequestMapping("/view")
	public String view(
			@RequestParam(value="no", required=true, defaultValue="0") Long no,
			Model model) {
		GalleryVo vo  = galleryService.view(no);
		model.addAttribute("vo", vo);
		model.addAttribute("url", GalleryService.URL );
		return "gallery/view";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="no", required=true, defaultValue="0") Long no){
		galleryService.delelte(no);
		return "redirect:/gallery";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(
			@RequestParam(value="comments", required=true, defaultValue="(내용없음)") String comments,
			@RequestParam(value="file") MultipartFile file,
			Model model){
		String url1 = galleryService.restore(file, comments);
		model.addAttribute("url1",url1);
		return "redirect:/gallery";
	}
	
}
