package kr.co.chunjae.gochowoo.model.User;

import kr.co.chunjae.gochowoo.model.base.BaseEntity;
import kr.co.chunjae.gochowoo.model.utils.Team;
import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "t_user")
@Setter @Getter
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
    @Column
    private Team team;
    @Column @Builder.Default
    private Character deleted = 'N';

    public void updateCash(int cash) {
        this.cash += cash;
    }
}
