package org.gonzalomelov.georeduy.bll.interfaces;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Product;

public interface ProductManagementService {
	public List<Product> getProducts();
	public void addProduct(Product p);
}
