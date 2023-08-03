package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.ProductModel;

public interface IProductDao {
	public List<ProductModel> findAll();
	public ProductModel insertOne(ProductModel product);
	public ProductModel updateOne(ProductModel ProductModel);
	public boolean enable(int productId);
	public boolean disable(int productId);
	public ProductModel findById(int productId);
}
