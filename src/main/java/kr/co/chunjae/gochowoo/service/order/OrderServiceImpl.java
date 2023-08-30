package kr.co.chunjae.gochowoo.service.order;

import kr.co.chunjae.gochowoo.dto.PurchaseDTO;
import kr.co.chunjae.gochowoo.repository.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<PurchaseDTO> getOrderList(Long id) {
        return orderRepository.findAllByUserId(id);
    }
}
