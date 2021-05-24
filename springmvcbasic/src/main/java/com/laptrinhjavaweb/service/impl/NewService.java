package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service("newService")
public class NewService implements INewService {

	@Autowired
	private NewConverter newConverter;

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entity = newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity : entity) {
			NewDTO newDTO = newConverter.toDTOv2(newEntity);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public void delete(long[] id) {
		for (long ids : id) {
			newRepository.delete(ids);
		}
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity newEntity = newRepository.findOne(id);
		return newConverter.toDTO(newEntity);
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO updateOrAddNew) {
		CategoryEntity category = categoryRepository.findOneByCode(updateOrAddNew.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if (updateOrAddNew.getId() != null) {
			NewEntity oldNew = newRepository.findOne(updateOrAddNew.getId());
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, updateOrAddNew);
		} else {
			newEntity = newConverter.toEntity(updateOrAddNew);
			newEntity.setCategory(category);
		}
		return newConverter.toDTO(newRepository.save(newEntity));
	}

}
