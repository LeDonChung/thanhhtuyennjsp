package com.laptrinhjavaweb.model;

public class CategoryModel {
	private Integer categoryId;
	private String name;
	private String code;
	private boolean is_activated; // đang hoạt động
	private boolean is_deleted; // đang được xóa
	
	public CategoryModel(Integer categoryId, String name, String code, boolean is_activated, boolean is_deleted) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.code = code;
		this.is_activated = is_activated;
		this.is_deleted = is_deleted;
	}
	public CategoryModel() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Category [id=" + categoryId + ", name=" + name + ", code=" + code + "]";
	}
	public boolean isIs_activated() {
		return is_activated;
	}
	public void setIs_activated(boolean is_activated) {
		this.is_activated = is_activated;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	
	
}
