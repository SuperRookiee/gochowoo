package kr.co.chunjae.gochowoo.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {
    private String product_id;
    private String name;
    private Long price;
    private int amount;
}
