package it.project_sushi.controller;

import java.util.List;

import it.project_sushi.model.dto.OrderDTO;
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
import org.springframework.web.bind.annotation.RestController;

import it.project_sushi.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Orders")
public class OrderController {
	@Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrdersA() {
        List<OrderDTO> orders = orderService.getAllOrderA();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/Deleted")
    public ResponseEntity<List<OrderDTO>> getAllOrdersC() {
        List<OrderDTO> orders = orderService.getAllOrderC();
        return ResponseEntity.ok(orders);
    }

    // 🔍 Recupera ordine per ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable long id) {
        OrderDTO order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🛒 Crea o aggiorna un ordine (carrello) in modo smart
    @PostMapping("/cart")
    public ResponseEntity<OrderDTO> saveOrUpdateCart(@RequestBody OrderDTO orderDTO) {
        OrderDTO saved = orderService.saveOrder(orderDTO);
        return ResponseEntity.ok(saved);
    }

    // ✏️ Modifica esplicita di un carrello tramite ID
    @PutMapping("/cart/{id}")
    public ResponseEntity<OrderDTO> updateCart(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        orderDTO.setId(id); // Forziamo l’ID per sicurezza
        OrderDTO updated = orderService.saveOrder(orderDTO);
        return ResponseEntity.ok(updated);
    }

    // ✅ Checkout ordine (separato, se vuoi trattarlo diversamente)
    @PostMapping("/checkout")
    public ResponseEntity<OrderDTO> checkout(@RequestBody OrderDTO orderDTO) {
        OrderDTO saved = orderService.saveOrder(orderDTO);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable long id) {
        OrderDTO deleted = orderService.deleteOrder(id);
        if (deleted != null) {
            return ResponseEntity.ok(deleted);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
