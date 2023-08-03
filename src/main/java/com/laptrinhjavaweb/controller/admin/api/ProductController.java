package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.Impl.ProductService;
import com.laptrinhjavaweb.utils.HttpUtil; 

@WebServlet(urlPatterns = "/api/products")
public class ProductController extends HttpServlet{
	@Inject
	private ProductService productService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String idParam = req.getParameter("id");
		ObjectMapper mapper = new ObjectMapper();
		if(idParam != null) {
			ProductModel model = productService.findById(Integer.valueOf(idParam));
			mapper.writeValue(resp.getOutputStream(), model);
		} else {
			List<ProductModel> results = productService.getAll();
			mapper.writeValue(resp.getOutputStream(), results);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); 
		resp.setContentType("application/json");
		ProductModel model = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
		ProductModel productNew = productService.insertOne(model);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), productNew);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); 
		resp.setContentType("application/json");
		String enableParam = req.getParameter("enable");
		String disableParam = req.getParameter("disable");
		if(enableParam != null) {
			
			ProductModel model = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
			productService.enableById(model.getProductId());
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), String.format("Khởi động sản phẩm có mã %d thành công", model.getProductId()));
		
		} else if(disableParam != null) {
			
			ProductModel model = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
			productService.disableById(model.getProductId());
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), String.format("Xóa sản phẩm có mã %d thành công", model.getProductId()));
		
		} else {
			
			ProductModel model = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
			ProductModel modelNew = productService.updateOne(model);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), modelNew);
		}
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
