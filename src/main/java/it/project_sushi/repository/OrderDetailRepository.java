package it.project_sushi.repository;

import it.project_sushi.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{

}
