package kr.co.chunjae.gochowoo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {
    private String product_id;
    private String name;
    private Long price;
    private int amount;
}
