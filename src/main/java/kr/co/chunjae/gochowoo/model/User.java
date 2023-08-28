package kr.co.chunjae.gochowoo.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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

}
