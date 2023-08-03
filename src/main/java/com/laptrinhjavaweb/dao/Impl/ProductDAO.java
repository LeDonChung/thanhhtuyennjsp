package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IProductDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.ProductModel;

public class ProductDAO extends AbstractDAO implements IProductDao {

	@Override
	public List<ProductModel> findAll() {
		Connection connect = getConnection();
		List<ProductModel> list = new ArrayList<>();
		Statement state = null;
		ResultSet rs = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM products";
				state = connect.createStatement();
				rs = state.executeQuery(query);
				while (rs.next()) {
					// handler
					int id = rs.getInt(1);
					String productName = rs.getString(2);
					double salePrice = rs.getDouble(3);
					double costPrice = rs.getDouble(4);
					int quantity = rs.getInt(5);
					String description = rs.getString(6);
					String imageUrl = rs.getString(7);
					boolean is_deleted = rs.getBoolean(9);
					boolean is_activated = rs.getBoolean(8);
					int categoryId = rs.getInt(10);
					ProductModel product = new ProductModel(id, productName, salePrice, costPrice, quantity, description, categoryId, imageUrl, is_activated, is_deleted);
					list.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (state != null) {
					try {
						state.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return list;
	}

	@Override
	public ProductModel insertOne(ProductModel product) {
		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		if (connect != null) {
			try {
				String query = "INSERT INTO products (product_name, sale_price, cost_price, quantity, description, imageUrl, is_activated, is_deleted, category_id) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				state = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				state.setString(1, product.getProductName());
				state.setDouble(2, product.getSalePrice());
				state.setDouble(3, product.getCostPrice());
				state.setInt(4, product.getQuantity());
				state.setString(5, product.getDescription());
				state.setString(6, product.getImageUrl());
				state.setBoolean(7, true);
				state.setBoolean(8, false);
				state.setInt(9, product.getCategoryId());
				state.executeUpdate();
				rs = state.getGeneratedKeys();

				while (rs.next()) {
					product.setProductId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (state != null) {
					try {
						state.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return product;
	}

	@Override
	public ProductModel updateOne(ProductModel product) {
		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		int status = 0;
		if (connect != null) {
			try {
				String query = "UPDATE products SET "
						+ "product_name = ?, "
						+ "sale_price = ?, "
						+ "cost_price = ?, "
						+ "quantity = ?, "
						+ "description = ?, "
						+ "category_id = ? "
						+ "WHERE id = ?";
				state = connect.prepareStatement(query);
				state.setString(1, product.getProductName());
				state.setDouble(2, product.getSalePrice());
				state.setDouble(3, product.getCostPrice());
				state.setInt(4, product.getQuantity());
				state.setString(5, product.getDescription());
				state.setInt(6, product.getCategoryId());
				state.setInt(7, product.getProductId());
				status = state.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (state != null) {
					try {
						state.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return status == 0 ? null : product;
	}

	@Override
	public boolean enable(int productId) {
		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		int status = 0;
		if (connect != null) {
			try {
				String query = "UPDATE products\r\n" + "SET is_activated = ?, is_deleted = ?\r\n" + "WHERE id = ?";
				state = connect.prepareStatement(query);
				state.setBoolean(1, true);
				state.setBoolean(2, false);
				state.setInt(3, productId);
				status = state.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (state != null) {
					try {
						state.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return status == 0 ? false: true;
	}

	@Override
	public boolean disable(int productId) {
		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		int status = 0;
		if (connect != null) {
			try {
				String query = "UPDATE products\r\n" + "SET is_activated = ?, is_deleted = ?\r\n" + "WHERE id = ?";
				state = connect.prepareStatement(query);
				state.setBoolean(1, false);
				state.setBoolean(2, true);
				state.setInt(3, productId);
				status = state.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (state != null) {
					try {
						state.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return status == 0 ? false: true;
	}

	@Override
	public ProductModel findById(int productId) {
		Connection connect = getConnection();
		Statement state = null;
		ResultSet rs = null;
		ProductModel result = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM products WHERE id = " + productId;
				state = connect.createStatement();
				rs = state.executeQuery(query);
				while (rs.next()) {
					// handler
					int id = rs.getInt(1);
					String productName = rs.getString(2);
					double salePrice = rs.getDouble(3);
					double costPrice = rs.getDouble(4);
					int quantity = rs.getInt(5);
					String description = rs.getString(6);
					String imageUrl = rs.getString(7);
					boolean is_deleted = rs.getBoolean(9);
					boolean is_activated = rs.getBoolean(8);
					int categoryId = rs.getInt(10);
					result = new ProductModel(id, productName, salePrice, costPrice, quantity, description, categoryId, imageUrl, is_activated, is_deleted);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (state != null) {
					try {
						state.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	

}
