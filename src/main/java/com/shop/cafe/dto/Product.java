package com.shop.cafe.dto;

public class Product {
	// 직접적인 외부 접근 막기 위해 private
	private int prodcode, price;
	private String prodname, pimg;
	
	 
	//getter, setter 메서드로 값 불러오기 or 변경
	// private이잖슴 public이어야 접근 가능
	public int getProdcode() {
		return prodcode;
	}
	public void setProdcode(int prodcode) {
		this.prodcode = prodcode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	@Override
	public String toString() {
		return "Product [prodcode=" + prodcode + ", price=" + price + ", prodname=" + prodname + ", pimg=" + pimg + "]";
	}
	public Product(int prodcode, int price, String prodname, String pimg) {
		super();
		this.prodcode = prodcode;
		this.price = price;
		this.prodname = prodname;
		this.pimg = pimg;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
