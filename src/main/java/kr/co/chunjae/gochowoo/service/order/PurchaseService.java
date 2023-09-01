package kr.co.chunjae.gochowoo.service.order;

import kr.co.chunjae.gochowoo.model.Order.Purchase.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchases();
    List<Purchase> getAllPurchasesByUserId(Long userId);

    Purchase getPurchaseByOrderId(Long orderId);
}
