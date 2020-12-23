package br.com.like.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(mappedBy = "question")
    private List<Reply> reply = new ArrayList<>();

    public Question(final Long id, final String description, final Product product) {
        this.id = id;
        this.description = description;
        this.product = product;
    }
}
