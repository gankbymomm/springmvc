package com.laptrinhjavaweb.dto;

public class NewDTO extends AbstractDTO<NewDTO> {

	private String title;
	private String thumbNail;
	private String content;
	private long categoryId;
	private String shortDescription;
	private String categoryCode;


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbNail() {
		return thumbNail;
	}
	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCatetoryId(long catetoryId) {
		this.categoryId = catetoryId;
	}
	public String getShortDescription() {
		return shortDescription;
	} 
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
}
