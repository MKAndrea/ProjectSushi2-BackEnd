package it.project_sushi.serviceImpl;

import java.util.List;

import it.project_sushi.model.Product;
import it.project_sushi.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project_sushi.mapper.ProductMapper;
import it.project_sushi.repository.ProductRepository;
import it.project_sushi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductDTO> getAllProduct() {
	    return productRepository.findAll().stream()
	            .filter(p -> Boolean.TRUE.equals(p.getActive())) // Mostra solo quelli attivi
	            .map(productMapper::toDto)
	            .toList();
	}
	public List<ProductDTO> getAllProductC() {
		return productRepository.findAll().stream()
	            .filter(p -> Boolean.FALSE.equals(p.getActive())) // Mostra solo quelli attivi
	            .map(productMapper::toDto)
	            .toList();
	}
	@Override
	public String getProductImageByName(String name) {
		return productRepository.findByName(name).stream()
				.findFirst()
				.filter(product -> Boolean.TRUE.equals(product.getActive()))
				.map(Product::getProductImage)
				.orElse(null);
	}
	@Override
	public List<ProductDTO> getProductsByCategory(Product.Category category) {
	    return productRepository.findByCategory(category).stream()
	            .filter(product -> Boolean.TRUE.equals(product.getActive())) // ✅ Mostra solo attivi
	            .map(productMapper::toDto)
	            .toList();
	}

	@Override
	public ProductDTO getProductById(long id) {
		return productRepository.findById(id)
				.filter(product -> Boolean.TRUE.equals(product.getActive()))
				.map(productMapper::toDto)
				.orElse(null);
	}

	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		Product product = (productDTO.getId() != null)
				? productRepository.findById(productDTO.getId())
						.map(existing -> {
							productMapper.updateFromDto(productDTO, existing);
							return existing;
						})
						.orElseThrow(() -> new RuntimeException("Tavolo con ID " + productDTO.getId() + " non trovato"))
						: productMapper.toEntity(productDTO);

		Product saved = productRepository.save(product);
		return productMapper.toDto(saved);
	}

	@Override
	public ProductDTO deleteProduct(long id) {
	    Product product = productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID: " + id));

	    // Elimina logicamente (disattiva)
	    product.setActive(false);
	    productRepository.save(product);

	    return productMapper.toDto(product);
	}

}
