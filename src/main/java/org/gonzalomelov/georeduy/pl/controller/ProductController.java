package org.gonzalomelov.georeduy.pl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.bll.interfaces.ProductManagementService;
import org.gonzalomelov.georeduy.dal.model.Product;

@ManagedBean
@RequestScoped
public class ProductController {
	
	@EJB(name="productManagement")
	private ProductManagementService productManagementService;
	
	private Product product = new Product();
	
	private List<Product> products = new ArrayList<Product>();
	
	public ProductController() {}
	
	@PostConstruct
	public void init(){
		products = productManagementService.getProducts();
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
		productManagementService.addProduct(product);
		return "/product/listProducts";
	}


	
	
	
}
 