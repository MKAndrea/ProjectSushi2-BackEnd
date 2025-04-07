package it.project_sushi.service;

import it.project_sushi.model.dto.ProductDTO;

import java.util.List;


public interface ProductService {
	List<ProductDTO> getAllProduct();
	ProductDTO getProductById(long id);
	String getProductImageByName(String name);
	ProductDTO saveProduct(ProductDTO productDTO);
	ProductDTO deleteProduct(long id);
}
