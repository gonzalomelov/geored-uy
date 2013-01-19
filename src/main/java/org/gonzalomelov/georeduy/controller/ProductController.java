package org.gonzalomelov.georeduy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.dal.model.Product;
import org.gonzalomelov.georeduy.service.ProductBean;

@ManagedBean
@RequestScoped
public class ProductController {
	
	@EJB
	private ProductBean productBean;
	
	private Product product = new Product();
	
	private List<Product> products = new ArrayList<Product>();
	
	public ProductController() {
		
	}
	
	@PostConstruct
	public void init(){
		products = productBean.getProducts();
	}

	public Product getProduct() {
		return product;
	}

	/*
	 * Getters and Setters
	 */
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void setProducts(List<Product> products){
		this.products = products;
	}
	
	/*
	 * Functions
	 */
	public String addProduct(){
		productBean.addProduct(product);
		return "/products/productList";
	}


	
	
	
}
 