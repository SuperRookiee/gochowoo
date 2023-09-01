package kr.co.chunjae.gochowoo.model.base;

import kr.co.chunjae.gochowoo.model.User.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter @Setter
public abstract class Cart {
    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    @Column
    @Builder.Default
    protected int amount = 1;
}
