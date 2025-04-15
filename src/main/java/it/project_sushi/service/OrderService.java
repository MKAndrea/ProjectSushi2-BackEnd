package it.project_sushi.service;

import it.project_sushi.model.dto.OrderDTO;

import java.util.List;


public interface OrderService {
	List<OrderDTO> getAllOrderA();
	List<OrderDTO> getAllOrderC();
	OrderDTO getOrderById(long id);
	OrderDTO saveOrder(OrderDTO orderDTO);
	OrderDTO deleteOrder(long id);
}
