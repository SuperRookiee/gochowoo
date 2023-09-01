package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.Order.Order;
import kr.co.chunjae.gochowoo.repository.Order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
