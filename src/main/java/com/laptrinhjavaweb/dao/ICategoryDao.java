package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDao {
	public List<CategoryModel> findAll();
	public CategoryModel insertOne(CategoryModel category);
	public CategoryModel updateOne(CategoryModel category);
	public boolean enable(int categoryId);
	public boolean disable(int categoryId);
	public CategoryModel findById(int categoryId);
}
