package kr.co.chunjae.gochowoo.service.order;

import kr.co.chunjae.gochowoo.model.Order.Order;
import kr.co.chunjae.gochowoo.model.Order.Purchase.Purchase;
import kr.co.chunjae.gochowoo.model.utils.ShippingStatus;
import kr.co.chunjae.gochowoo.repository.Order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchases();
    List<Purchase> getAllPurchasesByUserId(Long userId);

    Purchase getPurchaseByOrderId(Long orderId);

    interface OrderService {
        Order saveOrder(Order order);

        List<Order> getAllOrder();
        void changeOrdersStatus(List<Long> orderNumList, ShippingStatus status);
    }

    @AllArgsConstructor
    @Service
    class OrderServiceImpl implements OrderService {
        OrderRepository orderRepository;
        @Override
        public Order saveOrder(Order order) {
            return orderRepository.save(order);
        }

        @Override
        public List<Order> getAllOrder() {
            return orderRepository.findAll();
        }

        @Override
        public void changeOrdersStatus(List<Long> orderNumList, ShippingStatus status) {
            orderRepository.updateAllById(status, orderNumList);
        }
    }
}
