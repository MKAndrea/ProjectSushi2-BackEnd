package it.project_sushi.serviceImpl;

import java.util.List;

import it.project_sushi.model.Order;
import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.Product;
import it.project_sushi.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project_sushi.mapper.OrderMapper;
import it.project_sushi.repository.OrderRepository;
import it.project_sushi.repository.ProductRepository;
import it.project_sushi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<OrderDTO> getAllOrder() {
		return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
	}

	@Override
	public OrderDTO getOrderById(long id) {
		return orderRepository.findById(id)
				.map(orderMapper::toDto)
				.orElse(null);
	}

	@Override
	public OrderDTO saveOrder(OrderDTO orderDTO) {
	    Order order = new Order();

	    List<OrderDetail> details = orderDTO.getOrderDetails().stream().map(detailDTO -> {
	        OrderDetail detail = new OrderDetail();

	        Product product = detailDTO.getProduct() != null
	                ? productRepository.findById(detailDTO.getProduct().getId())
	                    .orElseThrow(() -> new RuntimeException("Prodotto non trovato"))
	                : null;

	        detail.setProduct(product);
	        detail.setOrders(order);
	        detail.setQuantity(detailDTO.getQuantity());
	        return detail;
	    }).toList();

	    order.setOrderDetails(details);

	    Order saved = orderRepository.save(order);
	    return orderMapper.toDto(saved);
	}
	
	@Override
	public OrderDTO deleteOrder(long id) {
		OrderDTO order = orderRepository.findById(id)
				.map(orderMapper::toDto)
				.orElse(null);
		productRepository.deleteById(id);
		return order;
	}

}
