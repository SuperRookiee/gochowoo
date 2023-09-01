package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.Order.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);

    List<Order> getAllOrder();
}
