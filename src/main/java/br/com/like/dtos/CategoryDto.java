package br.com.like.dtos;

import br.com.like.domains.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotNull(message = "Nome obrigatório")
    private String name;

    public Category fromEntity() {
        return new Category(null, getName(), null);
    }
}
