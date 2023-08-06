package com.laptrinhjavaweb.controller.admin.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.constrants.SystemConstrants;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.Impl.CategoryService;
import com.laptrinhjavaweb.utils.HttpUtil;

import javax.inject.Inject;

@WebServlet(urlPatterns = { "/api/categories" })
public class CategoryController extends HttpServlet {
	@Inject
	private CategoryService categoryService;

	// Lấy ra
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Định dạng nhận về
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		 
		String idParam = (String) req.getParameter("id");
		if(idParam != null ) { 
			CategoryModel result = categoryService.findById(Integer.valueOf(idParam));
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), result);
		} else {
			List<CategoryModel> results = categoryService.getAll();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), results);
		}
		
		
	}

	// Thêm mới
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Định dạng nhận về
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel model = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		CategoryModel modelNew = categoryService.insertOne(model);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), modelNew);
	}

	// Chỉnh sửa
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Định dạng nhận về
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String enableParam = req.getParameter("enable");
		String disableParam = req.getParameter("disable");
		if(enableParam != null) {
			
			CategoryModel model = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
			categoryService.enableById(model.getCategoryId());
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), String.format("Khởi động thể loại có mã %d thành công", model.getCategoryId()));
		
		} else if(disableParam != null) {
			
			CategoryModel model = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
			categoryService.disableById(model.getCategoryId());
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), String.format("Xóa thể loại có mã %d thành công", model.getCategoryId()));
		
		} else {
			
			CategoryModel model = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
			CategoryModel modelNew = categoryService.updateOne(model);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), modelNew);
		
		}
		
	}

	// Xóa
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
