package br.com.like.dtos;

import br.com.like.domains.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull(message = "Nome obrigatório")
    private String name;
    @NotNull(message = "Preço obrigatório")
    private Double price;

    public Product fromEntity() {
        return new Product(null, getName(), getPrice(), null);
    }
}
