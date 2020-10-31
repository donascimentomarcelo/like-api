package br.com.like.services.impl;

import br.com.like.domains.Product;
import br.com.like.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product create(final Product product) {
        return null;
    }

    @Override
    public void update(final Product product, final Long id) {

    }

    @Override
    public Product findOne(final Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Page<Product> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction) {
        return null;
    }
}
