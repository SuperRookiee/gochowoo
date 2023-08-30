package kr.co.chunjae.gochowoo.service.order;

import kr.co.chunjae.gochowoo.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchasesById(Long userId);
}
