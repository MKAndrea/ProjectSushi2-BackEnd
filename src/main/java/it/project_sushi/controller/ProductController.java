package it.project_sushi.controller;

import java.util.List;

import it.project_sushi.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.project_sushi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProduct());
	}

<<<<<<< HEAD
=======

>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable long id) {
		ProductDTO product = productService.getProductById(id);
		return (product != null) ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
	}

	@GetMapping("/image/{name}")
	public ResponseEntity<String> getProductImageName(@PathVariable String name) {
	    String imageName = productService.getProductImageByName(name);
	    if (imageName != null) {
	        return ResponseEntity.ok(imageName);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	    }

	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		productDTO.setId(null);
		ProductDTO created = productService.saveProduct(productDTO);
		return ResponseEntity.ok(created);
	}

<<<<<<< HEAD


	// PUT existing product (UPDATE)
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
		productDTO.setId(id);
=======
	// PUT existing product (UPDATE)
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
		productDTO.setId(id); 
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
		try {
			ProductDTO updated = productService.saveProduct(productDTO);
			return ResponseEntity.ok(updated);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// DELETE product by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable long id) {
		ProductDTO deleted = productService.deleteProduct(id);
		return (deleted != null) ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
	}
}
