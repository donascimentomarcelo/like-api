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
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqComment")
    @SequenceGenerator(name = "seqComment", sequenceName = "seq_id_comment")
    private Long id;

    private Integer star;
    private String title;
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Comment(final Integer star, final String title, final String description, final User user, final Product product) {
        this.star = star;
        this.title = title;
        this.description = description;
        this.user = user;
        this.product = product;
    }
}
