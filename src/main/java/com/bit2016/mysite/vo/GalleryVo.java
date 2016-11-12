package com.bit2016.mysite.vo;

public class GalleryVo {

	private Long no;
	private String orgFileName;
	private String saveFileName;
	private String comments;
	private String extName;
	private long fileSize;
	private String regDate;
	private long usersNo ;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Long getNo() {
		return no;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public String getExtName() {
		return extName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public String getRegDate() {
		return regDate;
	}
	public long getUsersNo() {
		return usersNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public void setUsersNo(long usersNo) {
		this.usersNo = usersNo;
	}
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", orgFileName=" + orgFileName + ", saveFileName=" + saveFileName + ", comments="
				+ comments + ", extName=" + extName + ", fileSize=" + fileSize + ", regDate=" + regDate + ", usersNo="
				+ usersNo + "]";
	}

}
