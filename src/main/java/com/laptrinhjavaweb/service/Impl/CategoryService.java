package com.laptrinhjavaweb.service.Impl;

import java.util.List;
import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Inject
	private ICategoryDao categoryDao;

	@Override
	public List<CategoryModel> getAll() {
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel insertOne(CategoryModel category) {
		return categoryDao.insertOne(category);
	}

	@Override
	public CategoryModel updateOne(CategoryModel category) {
		if(category.getCategoryId() == null) {
			return null;
		}
		return categoryDao.updateOne(category);
	}

	@Override
	public boolean enableById(int categoryId) {
		return categoryDao.enable(categoryId);
	}

	@Override
	public boolean disableById(int categoryId) {
		return categoryDao.disable(categoryId);
	}

	@Override
	public CategoryModel findById(int categoryId) {
		return categoryDao.findById(categoryId);
	}

}
