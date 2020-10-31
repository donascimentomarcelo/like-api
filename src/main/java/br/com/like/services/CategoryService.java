package br.com.like.services;

import br.com.like.domains.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Category create(final Category category);

    void update(final Category category, Long id);

    Category findOne(final Long id);

    List<Category> findAll();

    Page<Category> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction);
}
