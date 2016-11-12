package com.bit2016.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.mysite.repository.GuestbookDao;
import com.bit2016.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;
	
	public  List<GuestbookVo> getList() {
		return guestbookDao.getList();
	}
	
	public  List<GuestbookVo> getList(int page) {
		return guestbookDao.getList(page);
	}
	
	public void insert(GuestbookVo vo){
		guestbookDao.insert(vo);
	}
	
	public void delelte(GuestbookVo vo){
		guestbookDao.delete(vo);
	}
	
	public GuestbookVo writeMessage ( GuestbookVo vo ) {
		Long no = guestbookDao.insert(vo);
		System.out.println(no);
		return null;
	}
	

}
