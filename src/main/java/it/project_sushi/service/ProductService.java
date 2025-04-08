package it.project_sushi.service;

import it.project_sushi.model.dto.ProductDTO;

import java.util.List;


public interface ProductService {
	List<ProductDTO> getAllProduct();
<<<<<<< HEAD
	//List<ProductDTO> getAllProductWithoutMapper();
=======
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
	ProductDTO getProductById(long id);
	String getProductImageByName(String name);
	ProductDTO saveProduct(ProductDTO productDTO);
	ProductDTO deleteProduct(long id);
<<<<<<< HEAD
	ProductDTO saveProduct2(ProductDTO productDTO);
=======
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
}
