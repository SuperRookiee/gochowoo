package kr.co.chunjae.gochowoo.model.Community;


import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.model.base.BaseEntity;
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

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @Column(nullable = false)
    @Builder.Default
    private int hits = 0;

    @Column(nullable = false)
    @Builder.Default
    private char deleteYn = 'N';

}
