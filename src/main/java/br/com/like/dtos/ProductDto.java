package br.com.like.dtos;

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
public class ProductDto {

    @NotNull(message = "Nome do produto obrigatório")
    private String name;
    @NotNull(message = "Preço obrigatório")
    private Double price;
    @NotNull(message = "Descrição obrigatório")
    private String description;

    private Integer discount;
    private List<CommentDto> comments = new ArrayList<>();

    public static ProductDto fromDto(final Product product) {
        return new ProductDto(product.getName(), product.getPrice(), product.getDescription(), product.getDiscount(), CommentDto.convertList(product.getComments()));
    }

    public Product fromEntity() {
        return new Product(null, getName(), getPrice(), getDescription(), null, getDiscount(), null, null);
    }
}
