package kr.co.chunjae.gochowoo.model.User;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_user_address")
@Getter@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
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
