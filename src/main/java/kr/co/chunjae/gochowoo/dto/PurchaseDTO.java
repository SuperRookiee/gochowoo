package kr.co.chunjae.gochowoo.dto;

import kr.co.chunjae.gochowoo.model.OrderHistory;
import kr.co.chunjae.gochowoo.model.ShippingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {
    private Long id;
    private OrderHistory orderHistory;
    private Long userId;
    private Long userAddressId;
    private ShippingStatus status;
    private Long totalPrice;
    private String coupon;
}

