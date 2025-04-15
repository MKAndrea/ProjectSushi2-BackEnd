package it.project_sushi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import it.project_sushi.model.Order;
import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.Product;
import it.project_sushi.model.dto.OrderDTO;
import it.project_sushi.model.dto.OrderDetailDTO;

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
	public List<OrderDTO> getAllOrderA() {
	    return orderRepository.findAll().stream()
	            .filter(Order::isActive) // solo attivi
	            .map(orderMapper::toDto)
	            .toList();
	}
	@Override
	public List<OrderDTO> getAllOrderC() {
	    return orderRepository.findAll().stream()
	            .filter(order -> !order.isActive())
	            .map(orderMapper::toDto)
	            .toList();
	}

	@Override
	public OrderDTO getOrderById(long id) {
		return orderRepository.findById(id)
				.map(orderMapper::toDto)
				.orElse(null);
	}

	@Override
	public OrderDTO saveOrder(OrderDTO orderDTO) {
	    Order order;

	    if (orderDTO.getId() != null) {
	        order = orderRepository.findById(orderDTO.getId())
	                .orElseThrow(() -> new RuntimeException("Ordine non trovato con ID " + orderDTO.getId()));

	        if (order.getOrderDetails() == null) {
	            order.setOrderDetails(new ArrayList<>());
	        }

	    } else {
	        order = new Order();
	        order.setOrderDetails(new ArrayList<>());
	    }

	    // Mappa dei dettagli già presenti (esistenti nel DB)
	    Map<Long, OrderDetail> existingDetailsMap = order.getOrderDetails().stream()
	            .collect(Collectors.toMap(d -> d.getProduct().getId(), d -> d));

	    for (OrderDetailDTO detailDTO : orderDTO.getOrderDetails()) {
	        Long productId = detailDTO.getProduct().getId();

	        Product product = productRepository.findById(productId)
	                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID " + productId));

	        // Se già esiste, aggiorna quantità
	        OrderDetail detail = existingDetailsMap.get(productId);
	        if (detail != null) {
	            detail.setQuantity(detailDTO.getQuantity()); // puoi anche sommare se vuoi
	        } else {
	            // Altrimenti, crea un nuovo dettaglio
	            detail = new OrderDetail();
	            detail.setProduct(product);
	            detail.setOrders(order);
	            detail.setQuantity(detailDTO.getQuantity());
	            order.getOrderDetails().add(detail); // aggiunta
	        }
	    }

	    Order saved = orderRepository.save(order);
	    return orderMapper.toDto(saved);
	}

//	@Override
//	public OrderDTO saveOrder(OrderDTO orderDTO) {
//	    Order order;
//
//	    if (orderDTO.getId() != null) {
//	        order = orderRepository.findById(orderDTO.getId())
//	                .orElseThrow(() -> new RuntimeException("Ordine non trovato con ID " + orderDTO.getId()));
//
//	        if (order.getOrderDetails() == null) {
//	            order.setOrderDetails(new ArrayList<>());
//	        }
//
//	    } else {
//	        order = new Order();
//	        order.setOrderDetails(new ArrayList<>());
//	    }
//
//	    // Mappa dei dettagli già presenti (esistenti nel DB)
//	    Map<Long, OrderDetail> existingDetailsMap = order.getOrderDetails().stream()
//	            .collect(Collectors.toMap(d -> d.getProduct().getId(), d -> d));
//
//	    for (OrderDetailDTO detailDTO : orderDTO.getOrderDetails()) {
//	        Long productId = detailDTO.getProduct().getId();
//
//	        Product product = productRepository.findById(productId)
//	                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID " + productId));
//
//	        // Se già esiste, somma la quantità
//	        OrderDetail detail = existingDetailsMap.get(productId);
//	        if (detail != null) {
//	            int updatedQuantity = detail.getQuantity() + detailDTO.getQuantity(); // 👈 somma
//	            detail.setQuantity(updatedQuantity);
//	        } else {
//	            // Altrimenti, crea un nuovo dettaglio
//	            detail = new OrderDetail();
//	            detail.setProduct(product);
//	            detail.setOrders(order);
//	            detail.setQuantity(detailDTO.getQuantity());
//	            order.getOrderDetails().add(detail); // aggiunta
//	        }
//	    }
//
//	    Order saved = orderRepository.save(order);
//	    return orderMapper.toDto(saved);
//	}




	@Override
	public OrderDTO deleteOrder(long id) {
	    Order order = orderRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Ordine non trovato con ID " + id));

	    order.setActive(false); // soft delete
	    orderRepository.save(order);

	    return orderMapper.toDto(order);
	}

}
