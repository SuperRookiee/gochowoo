package kr.co.chunjae.gochowoo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "t_community")
@Data
@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
public class Community extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User writer;

    @Column(nullable = false)
    private int hits;

    @Column(nullable = false)
    private char deleteYn;

}
