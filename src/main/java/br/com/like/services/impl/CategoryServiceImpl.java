package br.com.like.services.impl;

import br.com.like.constants.Constants;
import br.com.like.domains.Category;
import br.com.like.exceptions.models.ObjectNotFoundException;
import br.com.like.repositories.CategoryRepository;
import br.com.like.repositories.ProductRepository;
import br.com.like.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Category create(final Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void update(final Category category, final Long id) {
        category.setId(id);
        categoryRepository.save(category);
    }

    @Override
    public Category findOne(final Long id) {
        final Optional<Category> category = categoryRepository.findById(id);
        return category
                .orElseThrow(() -> new ObjectNotFoundException(Constants.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction) {
        final PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoryRepository.findAll(pageRequest);
    }

    @Override
    public void associateProduct(final Category category) {
        categoryRepository.save(category);
        productRepository.saveAll(category.getProducts());
    }
}
