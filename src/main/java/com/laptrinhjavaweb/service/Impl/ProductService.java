package com.laptrinhjavaweb.service.Impl;

import java.util.List;
import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IProductDao;
import com.laptrinhjavaweb.dao.impl.ProductDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.IProductService;

public class ProductService implements IProductService{
	
	@Inject
	private ProductDAO productDAO;
	
	@Override
	public List<ProductModel> getAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public ProductModel insertOne(ProductModel product) {
		// TODO Auto-generated method stub
		return productDAO.insertOne(product);
	}

	@Override
	public ProductModel updateOne(ProductModel product) {
		// TODO Auto-generated method stub
		return productDAO.updateOne(product);
	}

	@Override
	public boolean enableById(int productId) {
		// TODO Auto-generated method stub
		return productDAO.enable(productId);
	}

	@Override
	public boolean disableById(int productId) {
		// TODO Auto-generated method stub
		return productDAO.disable(productId);
	}

	@Override
	public ProductModel findById(int productId) {
		// TODO Auto-generated method stub
		return productDAO.findById(productId);
	}


}
 