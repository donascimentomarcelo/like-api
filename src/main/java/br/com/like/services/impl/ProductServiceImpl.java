package br.com.like.services.impl;

import br.com.like.constants.Constants;
import br.com.like.domains.Product;
import br.com.like.exceptions.models.ObjectNotFoundException;
import br.com.like.repositories.ProductRepository;
import br.com.like.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(final Product product) {
        return productRepository.save(product);
    }

    @Override
    public void update(final Product product, final Long id) {
        product.setId(id);
        productRepository.save(product);
    }

    @Override
    public Product findOne(final Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Constants.PRODUCT_NOT_FOUND));
    }

    @Override
    public List<Product> findAll() {
        final List<Product> products = productRepository.findAll();
        return applyDiscountAtProductList(products);
    }

    private List<Product> applyDiscountAtProductList(final List<Product> products) {
        return products.stream()
                .map(product -> {
                    product.setOldPrice(product.applyDiscount());
                    return product;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Page<Product> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction) {
        final PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return productRepository.findAll(pageRequest);
    }

    @Override
    public List<Product> productsByCategory(final Long id) {
        return productRepository.findProductsByCategory(id);
    }

    @Override
    public List<Product> findByProductsOrCategories(final String text) {
        return productRepository.findByProductsOrCategories(text);
    }
}
