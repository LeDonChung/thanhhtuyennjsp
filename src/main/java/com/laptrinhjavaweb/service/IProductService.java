package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface IProductService {
	public List<ProductModel> findAll();

	public ProductModel insertOne(ProductModel product);

	public int deleteOne(int productId);
}
