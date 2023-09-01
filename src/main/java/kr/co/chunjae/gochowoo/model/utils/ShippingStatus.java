package kr.co.chunjae.gochowoo.model.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum ShippingStatus {
    PENDING("주문 접수"),
    SHIPPED("집하 처리"),
    IN_TRANSIT("배송 중"),
    DELIVERED("배송 완료"),
    FAILED("배송 오류");
    private final String ko;
}