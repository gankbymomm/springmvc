package com.laptrinhjavaweb.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO extends AbstractDTO<UserDTO>{
	
	@NotNull
	@Size(min = 3, max = 20, message = "Tên đăng nhập phải có nhiều hơn 3 ký tự")
	private String userName;
	
	@NotNull
	@Size(min = 1, message = "Điền tên của bạn")
	private String fullName;
	
	@NotNull
	@Size(min = 6, message = "Mật khẩu bắt buộc có hơn 6 ký tự")
	private String passWord;
	
	@NotNull
	@Size(min = 6, message = "Mật khẩu nhập lại phải chính xác")
	private String passWordConfirm;
	
	private int status;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPassWordConfirm() {
		return passWordConfirm;
	}
	public void setPassWordConfirm(String passWordConfirm) {
		this.passWordConfirm = passWordConfirm;
	}
	
	
}
