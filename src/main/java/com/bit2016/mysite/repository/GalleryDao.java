package com.bit2016.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.mysite.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;

	public int insert(GalleryVo galleryVo) {
		return sqlSession.insert("gallery.insert", galleryVo);
	}

	public void delete(Long	no) {
		sqlSession.delete("gallery.delete", no);
	}

	public List<GalleryVo> getList() {
		return sqlSession.selectList("gallery.getList");
	}
	
	public GalleryVo view(Long no){
		return sqlSession.selectOne("gallery.view",no);
	}
	
/*	public List<GalleryVo> getList( Integer page) {
		return  sqlSession.selectList("guestbook.getListByPage", page);
		}*/
	
}
