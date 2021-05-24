package com.laptrinhjavaweb.DAO;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status);
}
