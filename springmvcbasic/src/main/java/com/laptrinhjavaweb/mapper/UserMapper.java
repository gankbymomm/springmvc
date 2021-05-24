package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel users = new UserModel();
			users.setId(rs.getLong("id"));
			users.setUserName(rs.getString("username"));
			users.setPassWord(rs.getString("password"));
			users.setFullName(rs.getString("fullname"));
			users.setStatus(rs.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
//			users.setCreateDate(rs.getTimestamp("createddate"));
//			users.setCreateBy(rs.getString("createdby"));
//			if (rs.getTimestamp("modifieddate") != null) {
//				users.setModifiedDate(rs.getTimestamp("modifieddate"));
//			}
//			if (rs.getTimestamp("modifiedby") != null) {
//				users.setModifiedBy(rs.getString("modifiedby"));
//			}
			return users;
		}catch (SQLException e) {
			return null;
		}
	}
}
