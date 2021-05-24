package com.laptrinhjavaweb.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findAll() {
		String sql = "SELECT * FROM news";
		return query(sql.toString(), new NewMapper());
	}
	
}
