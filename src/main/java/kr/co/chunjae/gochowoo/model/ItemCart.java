package kr.co.chunjae.gochowoo.model;

import kr.co.chunjae.gochowoo.model.base.Cart;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "t_item_cart")
public class ItemCart extends Cart {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

}
