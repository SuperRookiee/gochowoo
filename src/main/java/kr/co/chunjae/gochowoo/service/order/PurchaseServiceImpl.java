package kr.co.chunjae.gochowoo.service.order;

import kr.co.chunjae.gochowoo.model.Purchase;
import kr.co.chunjae.gochowoo.repository.order.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }
}
