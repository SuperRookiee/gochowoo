package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.Order;
import kr.co.chunjae.gochowoo.repository.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
