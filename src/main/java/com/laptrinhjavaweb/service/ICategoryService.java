package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryService {
	public List<CategoryModel> getAll();
	public CategoryModel insertOne(CategoryModel category);
	public CategoryModel updateOne(CategoryModel category);
	public boolean enableById(int categoryId);
	public boolean disableById(int categoryId);
	public CategoryModel findById(int categoryId);
}
