package it.project_sushi.repository;

import java.util.List;

import it.project_sushi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	List<Product> findByName(String name);
	List<Product> findByCategory(Product.Category category);
}
