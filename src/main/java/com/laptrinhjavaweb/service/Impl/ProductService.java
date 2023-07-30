package com.laptrinhjavaweb.service.Impl;

import java.util.List;
import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IProductDao;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.IProductService;

public class ProductService implements IProductService{

	@Inject
	private IProductDao productDao;
	
	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public ProductModel insertOne(ProductModel product) {
		// TODO Auto-generated method stub
		return productDao.insertOne(product);
	}

	@Override
	public int deleteOne(int productId) {
		// TODO Auto-generated method stub
		return productDao.deleteOne(productId);
	}

}
 