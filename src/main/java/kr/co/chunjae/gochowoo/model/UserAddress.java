package kr.co.chunjae.gochowoo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_user_address")
@Getter@Setter
public class UserAddress {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 15)
    private String recipient;
    @Column(nullable = false, length = 15)
    private String phoneNumber;
    @Column(nullable = false)
    private String address;
    @Column
    private String deliveryRequest;

}
