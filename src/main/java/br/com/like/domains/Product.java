package br.com.like.domains;

import br.com.like.constants.Constants;
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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqProduct")
    @SequenceGenerator(name = "seqProduct", sequenceName = "seq_id_product")
    private Long id;
    private String name;
    private Double price;
    private String description;
    @Transient
    private Double oldPrice;
    private Integer discount;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "PRODUCT_CATEGORY",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    public Double applyDiscount() {
        return getDiscount() != null ?
                (getPrice() / Constants.ONE_HUNDRED) * getDiscount() :
                null;
    }

    public Product(final Long id, final String name, final Double price, final String description, final Integer discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
    }

    public Product(final String name, final Double price, final String description, final Integer discount) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
    }
}
