package kr.co.chunjae.gochowoo.service.order;

import kr.co.chunjae.gochowoo.dto.PurchaseDTO;

import java.util.List;

public interface OrderService {
    List<PurchaseDTO> getOrderList(Long id);
}
