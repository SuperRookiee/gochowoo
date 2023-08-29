package kr.co.chunjae.gochowoo.model;

import kr.co.chunjae.gochowoo.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "t_user")
@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true, length = 30)
    private String nickName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true, length = 30)
    private String email;
    @Column @Builder.Default
    private Long cash = 0L;

}
