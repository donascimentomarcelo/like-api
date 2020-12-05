package br.com.like.domains;

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
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqCategory")
    @SequenceGenerator(name = "seqCategory", sequenceName = "seq_id_category")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    public Category(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Category(final String name) {
        this.name = name;
    }
}
