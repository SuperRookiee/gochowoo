package kr.co.chunjae.gochowoo.model.Item;

import kr.co.chunjae.gochowoo.model.base.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
