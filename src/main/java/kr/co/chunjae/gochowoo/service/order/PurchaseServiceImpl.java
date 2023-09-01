package kr.co.chunjae.gochowoo.service.order;

import kr.co.chunjae.gochowoo.model.Order.Purchase.Purchase;
import kr.co.chunjae.gochowoo.repository.Order.Purchase.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchasesByUserId(Long userId) {
        return purchaseRepository.findAllByUserIdOrderByCreatedTimeDesc(userId);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAllByOrderByCreatedTimeDesc();
    }
    public Purchase getPurchaseByOrderId(Long orderId) {
        return purchaseRepository.findAllByOrderId(orderId);
    }
}
