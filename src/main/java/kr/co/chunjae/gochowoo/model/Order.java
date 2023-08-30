package kr.co.chunjae.gochowoo.model;

import kr.co.chunjae.gochowoo.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "t_order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private List<OrderHistory> orderHistory;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private UserAddress userAddress;

    @Column
    @Builder.Default
    private ShippingStatus status = ShippingStatus.PENDING;

    @Column
    private Long totalPrice;

    @Column
    private String coupon;
}
