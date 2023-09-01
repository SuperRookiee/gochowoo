package kr.co.chunjae.gochowoo.model.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {
    private String productId;
    private String name;
    private Long price;
    private int amount;
}
