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
		return productRepository.findAll().stream().map(productMapper::toDto).toList();
	}
	@Override
	public String getProductImageByName(String name) {
		  return productRepository.findByName(name).stream()
			        .findFirst()
			        .map(Product::getProductImage)
			        .orElse(null);
	}
	@Override
	public ProductDTO getProductById(long id) {
		return productRepository.findById(id)
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
	public ProductDTO saveProduct2(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setIngredients(productDTO.getIngredients());
		product.setPrice(productDTO.getPrice());
		product.setProductImage(productDTO.getProductImage());

		Product saved = productRepository.save(product);
		return productDTO;
	}
	@Override
	public ProductDTO deleteProduct(long id) {
		ProductDTO product = productRepository.findById(id)
				.map(productMapper::toDto)
				.orElse(null);
		productRepository.deleteById(id);
		return product;
	}

}
