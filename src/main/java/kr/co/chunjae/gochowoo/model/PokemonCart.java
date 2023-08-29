package kr.co.chunjae.gochowoo.model;

import kr.co.chunjae.gochowoo.model.base.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder @Builder
@Table(name = "t_pokemon_cart")
public class PokemonCart extends Cart {
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id")
    @Setter
    private Pokemon pokemon;
}
