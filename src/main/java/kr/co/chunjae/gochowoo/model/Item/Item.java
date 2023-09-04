package kr.co.chunjae.gochowoo.model.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_item")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer number;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, length = 500)
    private String description;

    @Column
    private Integer price;
}
