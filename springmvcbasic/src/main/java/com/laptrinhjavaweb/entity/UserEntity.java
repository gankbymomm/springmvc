package com.laptrinhjavaweb.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable ;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "password")
	private String passWord;
	
	@Column(name = "passwordconfirm")
	private String passWordConfirm;

	@Column(name = "status")
	private int status;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), 
									inverseJoinColumns = @JoinColumn(name = "roleid"))
	private Collection<RoleEntity> roles;
	
	public void addRole(RoleEntity role) {
		this.roles.add(role);
	}

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

	public String getPassWordConfirm() {
		return passWordConfirm;
	}

	public void setPassWordConfirm(String passWordConfirm) {
		this.passWordConfirm = passWordConfirm;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Collection<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleEntity> roles) {
		this.roles = roles;
	}
	
	
}
