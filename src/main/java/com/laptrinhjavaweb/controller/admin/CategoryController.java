package com.laptrinhjavaweb.controller.admin;

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
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.Impl.CategoryService;

import javax.inject.Inject;

@WebServlet(urlPatterns = { "/admin/categories" })
public class CategoryController extends HttpServlet {
	@Inject
	private CategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category.jsp");
		List<CategoryModel> categories = categoryService.getAll();
		req.setAttribute(SystemConstrants.CATEGORIES, categories);
		req.setAttribute(SystemConstrants.TITLE, "Category Manager");
		
		// Lấy message
		String message = req.getParameter(SystemConstrants.MESSAGE);
		if(message != null) {
			if(message.equals("DELETE_CATEGORY_SUCCESS")) {
				req.setAttribute("responseMessage", "Xóa thể loại thành công.");
			} else if(message.equals("ENABLE_CATEGORY_SUCCESS")) {
				req.setAttribute("responseMessage", "Bật thể loại thành công.");
			} else if(message.equals("SOMETHING_WENT_WRONG")) {
				req.setAttribute("responseMessage", "Đã xảy ra sự cố.");
			}  
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	} 

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		super.doDelete(req, resp);
	}
}
