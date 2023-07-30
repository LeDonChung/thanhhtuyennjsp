package com.laptrinhjavaweb.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IProductDao;
import com.laptrinhjavaweb.model.ProductModel;

public class ProductDAO extends AbstractDAO implements IProductDao {

	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel insertOne(ProductModel product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOne(int productId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
