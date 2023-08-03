package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.ProductModel;

public interface IProductService {
	public List<ProductModel> getAll();
	public ProductModel insertOne(ProductModel product);
	public ProductModel updateOne(ProductModel product);
	public boolean enableById(int productId);
	public boolean disableById(int productId);
	public ProductModel findById(int productId);
}
