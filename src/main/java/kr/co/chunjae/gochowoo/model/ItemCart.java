package kr.co.chunjae.gochowoo.model;

import kr.co.chunjae.gochowoo.model.base.Cart;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Setter @Getter
@Table(name = "t_item_cart")
public class ItemCart extends Cart {

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
