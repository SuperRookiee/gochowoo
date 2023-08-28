package kr.co.chunjae.gochowoo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int number;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, length = 500)
    private String description;

    @Column
    private int price;
}
