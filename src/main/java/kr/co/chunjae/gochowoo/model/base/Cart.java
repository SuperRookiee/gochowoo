package kr.co.chunjae.gochowoo.model.base;

import kr.co.chunjae.gochowoo.model.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Cart {
    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    protected User user;

    @Column
    @Builder.Default
    protected int amount = 1;
}
