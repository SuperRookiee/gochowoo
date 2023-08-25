package kr.co.chunjae.gochowoo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_pokemon")
@Getter@Setter
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private int number;
    @Column(nullable = false, unique = true, length = 30)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(nullable = false, length = 500)
    private String description;
    @Column
    private int price;

}
