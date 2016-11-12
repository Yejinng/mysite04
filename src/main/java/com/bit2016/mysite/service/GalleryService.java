package com.bit2016.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.mysite.repository.GalleryDao;
import com.bit2016.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	private static final String SAVE_PATH = "/upload"; 
	public static final String URL = "/gallery/assets"; 

	@Autowired
	private GalleryDao galleryDao;
	
	public  List<GalleryVo> getList() {
		return galleryDao.getList();
	}

	public void insert(GalleryVo vo){
		galleryDao.insert(vo);
	}
	
	public void delelte(Long no){
		galleryDao.delete(no);
	}
	public GalleryVo view(Long no) {
		System.out.println(no);
		return galleryDao.view(no);
	}
	public String restore(MultipartFile multipartFile, String comments) {
		String url = "";
		GalleryVo galleryVo = null;
		try {
			if (multipartFile.isEmpty() == true) {
				
				return url;
			}
			String originalFileName = multipartFile.getOriginalFilename();
			String extName = originalFileName.substring(originalFileName.lastIndexOf('.') + 1,
					originalFileName.length());
			String saveFileName = generateSaveFileName(extName);
			Long fileSize = multipartFile.getSize();

			writeFile(multipartFile, saveFileName);
			
			url = URL + saveFileName;
			galleryVo = new GalleryVo();
			galleryVo.setOrgFileName(originalFileName);
			galleryVo.setExtName(extName);
			galleryVo.setSaveFileName(saveFileName);
			galleryVo.setFileSize(fileSize);
			galleryVo.setComments(comments);
			
			galleryDao.insert(galleryVo);
		} catch (IOException ex) {
			//throw new UploadFileException("write file");
			//log 남기기
			throw new RuntimeException("write file");
		}
		return url;
	}
	
	private void writeFile( MultipartFile multipartFile, String saveFileName) throws IOException {
		
			byte[] fileData = multipartFile.getBytes();
			FileOutputStream fos = new FileOutputStream( SAVE_PATH + "/" + saveFileName );
			fos.write( fileData );
			
			if (fos != null) {
				fos.close();
			}
		
	}
	private String generateSaveFileName( String ext) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		
		fileName += calendar.get( Calendar.YEAR );
		fileName += calendar.get( Calendar.MONTH );
		fileName += calendar.get( Calendar.DATE );
		fileName += calendar.get( Calendar.HOUR );
		fileName += calendar.get( Calendar.MINUTE );
		fileName += calendar.get( Calendar.SECOND );
		fileName += calendar.get( Calendar.MILLISECOND );
		fileName += ("." + ext );
		
		return fileName;
	}
}
