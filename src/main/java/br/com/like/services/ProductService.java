package br.com.like.services;

import br.com.like.domains.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product create(final Product product);

    void update(final Product product, Long id);

    Product findOne(final Long id);

    List<Product> findAll();

    Page<Product> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction);

    List<Product> productsByCategory(final Long id);

    List<Product> findByProductsOrCategories(final String text);
}
