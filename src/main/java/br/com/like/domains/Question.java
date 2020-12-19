package br.com.like.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqQuestion")
    @SequenceGenerator(name = "seqQuestion", sequenceName = "seq_id_question")
    private Long id;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
