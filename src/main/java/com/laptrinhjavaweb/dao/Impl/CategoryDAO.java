package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO implements ICategoryDao {

	@Override
	public List<CategoryModel> findAll() {
		Connection connect = getConnection();
		List<CategoryModel> list = new ArrayList<>();
		Statement state = null;
		ResultSet rs = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM categories";
				state = connect.createStatement();
				rs = state.executeQuery(query);
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String code = rs.getString(3);
					boolean is_deleted = rs.getBoolean(4);
					boolean is_activated = rs.getBoolean(5);
					CategoryModel category = new CategoryModel(id, name, code, is_activated, is_deleted);
					list.add(category);
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
	public CategoryModel insertOne(CategoryModel category) {
		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		if (connect != null) {
			try {
				String query = "INSERT INTO categories (name, code, is_activated, is_deleted) VALUES (?, ?, ?, ?)";
				state = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				state.setString(1, category.getName());
				state.setString(2, category.getCode());
				state.setBoolean(3, true);
				state.setBoolean(4, false);
				state.executeUpdate();
				rs = state.getGeneratedKeys();

				while (rs.next()) {
					category.setCategoryId(rs.getInt(1));
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
		return category;
	}

	@Override
	public CategoryModel updateOne(CategoryModel category) {

		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		int status = 0;
		if (connect != null) {
			try {
				String query = "UPDATE categories\r\n" + "SET name = ?, code = ?\r\n" + "WHERE id = ?";
				state = connect.prepareStatement(query);
				state.setString(1, category.getName());
				state.setString(2, category.getCode());
				state.setInt(3, category.getCategoryId());
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
		
		return status == 0 ? null : category;
	}

	@Override
	public boolean enable(int categoryId) {
		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		int status = 0;
		if (connect != null) {
			try {
				String query = "UPDATE categories\r\n" + "SET is_activated = ?, is_deleted = ?\r\n" + "WHERE id = ?";
				state = connect.prepareStatement(query);
				state.setBoolean(1, true);
				state.setBoolean(2, false);
				state.setInt(3, categoryId);
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
	public boolean disable(int categoryId) {
		Connection connect = getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
		int status = 0;
		if (connect != null) {
			try {
				String query = "UPDATE categories\r\n" + "SET is_activated = ?, is_deleted = ?\r\n" + "WHERE id = ?";
				state = connect.prepareStatement(query);
				state.setBoolean(1, false);
				state.setBoolean(2, true);
				state.setInt(3, categoryId);
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
	public CategoryModel findById(int categoryId) {
		Connection connect = getConnection();
		Statement state = null;
		ResultSet rs = null;
		CategoryModel result = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM categories WHERE id = " + categoryId;
				state = connect.createStatement();
				rs = state.executeQuery(query);
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String code = rs.getString(3);
					boolean is_deleted = rs.getBoolean(4);
					boolean is_activated = rs.getBoolean(5);
					result = new CategoryModel(id, name, code, is_activated, is_deleted);
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
