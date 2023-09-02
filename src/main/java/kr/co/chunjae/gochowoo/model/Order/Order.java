package kr.co.chunjae.gochowoo.model.Order;

import kr.co.chunjae.gochowoo.model.User.UserAddress;
import kr.co.chunjae.gochowoo.model.base.BaseEntity;
import kr.co.chunjae.gochowoo.model.utils.ShippingStatus;
import lombok.*;

import javax.persistence.*;

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

    @Column(columnDefinition = "json")
    private String orderHistory;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private UserAddress userAddress;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ShippingStatus status = ShippingStatus.PENDING;

    @Column
    private Long totalPrice;

    @Column
    private String coupon;
}
