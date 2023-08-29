package kr.co.chunjae.gochowoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Table(name = "t_user")
@Data
@Builder @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 30)
    private String nickName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true, length = 30)
    private String email;
    @Column @Builder.Default
    private Long cash = 0L;

    public void updateCash(int cash) {
        this.cash += cash;
    }
}
