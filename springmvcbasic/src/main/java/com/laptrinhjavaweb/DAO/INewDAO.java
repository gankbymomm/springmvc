package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findAll();
}
