package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface IProductDao {
	public List<ProductModel> findAll();

	public ProductModel insertOne(ProductModel product);

	public int deleteOne(int productId);
}
