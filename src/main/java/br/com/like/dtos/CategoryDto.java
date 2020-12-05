package br.com.like.dtos;

import br.com.like.domains.Category;
import br.com.like.domains.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotNull(message = "Nome da categoria obrigatório")
    private String name;
    private List<Product> products = new ArrayList<>();

    public Category fromEntity() {
        return new Category(null, getName(), null);
    }

    public Category joinProduct(final Long id) {
        return new Category(id, getName(), getProducts());
    }
}
