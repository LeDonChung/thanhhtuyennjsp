package com.laptrinhjavaweb.model;

public class ProductModel {
	private int productId;
	private String productName;
	private double salePrice;
	private double costPrice;
	private int quantity;
	private String description;
	private int categoryId;
	private String imageUrl;
	private boolean is_activated; // đang hoạt động
	private boolean is_deleted; // đang được xóa


	public ProductModel() {
	}

	public ProductModel(int productId, String productName, double salePrice, double costPrice, int quantity,
			String description, int categoryId, String imageUrl, boolean is_activated, boolean is_deleted) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.quantity = quantity;
		this.description = description;
		this.categoryId = categoryId;
		this.imageUrl = imageUrl;
		this.is_activated = is_activated;
		this.is_deleted = is_deleted;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public boolean isIs_activated() {
		return is_activated;
	}

	public void setIs_activated(boolean is_activated) {
		this.is_activated = is_activated;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", salePrice=" + salePrice
				+ ", costPrice=" + costPrice + ", quantity=" + quantity + ", description=" + description
				+ ", categoryId=" + categoryId + ", imageUrl=" + imageUrl + ", is_activated=" + is_activated
				+ ", is_deleted=" + is_deleted + "]";
	}

}
