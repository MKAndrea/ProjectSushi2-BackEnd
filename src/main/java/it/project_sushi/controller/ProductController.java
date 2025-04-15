package it.project_sushi.controller;

import java.util.List;

import it.project_sushi.model.Product;
import it.project_sushi.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.project_sushi.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProductsA() {
		return ResponseEntity.ok(productService.getAllProduct());
	}
	@GetMapping("/deleted")
	public ResponseEntity<List<ProductDTO>> getAllProductsC() {
		return ResponseEntity.ok(productService.getAllProductC());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable long id) {
		ProductDTO product = productService.getProductById(id);
		return (product != null) ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable Product.Category category) {
	    List<ProductDTO> products = productService.getProductsByCategory(category);
	    return ResponseEntity.ok(products);
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
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO,
	                                                @RequestParam String username,
	                                                @RequestParam String password) {
	    if (!username.equals("admin") || !password.equals("adminpass")) {
	        return ResponseEntity.status(401).build(); // Unauthorized
	    }

	    productDTO.setId(null);
	    ProductDTO created = productService.saveProduct(productDTO);
	    return ResponseEntity.ok(created);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable long id,
	                                                @RequestBody ProductDTO productDTO,
	                                                @RequestParam String username,
	                                                @RequestParam String password) {
	    if (!username.equals("admin") || !password.equals("adminpass")) {
	        return ResponseEntity.status(401).build();
	    }

	    productDTO.setId(id);
	    try {
	        ProductDTO updated = productService.saveProduct(productDTO);
	        return ResponseEntity.ok(updated);
	    } catch (RuntimeException e) {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable long id,
	                                                @RequestParam String username,
	                                                @RequestParam String password) {
	    if (!username.equals("admin") || !password.equals("adminpass")) {
	        return ResponseEntity.status(401).build();
	    }
	    ProductDTO deleted = productService.deleteProduct(id);
	    return (deleted != null) ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
	}

}
