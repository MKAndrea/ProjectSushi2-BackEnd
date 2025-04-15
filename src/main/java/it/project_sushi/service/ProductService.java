package it.project_sushi.service;

import it.project_sushi.model.Product;
import it.project_sushi.model.dto.ProductDTO;

import java.util.List;


public interface ProductService {
	List<ProductDTO> getAllProduct();
	List<ProductDTO> getAllProductC();
	ProductDTO getProductById(long id);
	String getProductImageByName(String name);
	List<ProductDTO> getProductsByCategory(Product.Category category);
	ProductDTO saveProduct(ProductDTO productDTO);
	ProductDTO deleteProduct(long id);
}
