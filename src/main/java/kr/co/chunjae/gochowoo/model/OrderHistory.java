package kr.co.chunjae.gochowoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {
    private String product_id;
    private String name;
    private Long price;
    private int amount;
}
