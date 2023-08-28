package kr.co.chunjae.gochowoo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_cart")
@Getter@Setter
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
    @Column
    private int amount = 1;

}
