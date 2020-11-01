package br.com.like.resources;

import br.com.like.domains.Category;
import br.com.like.dtos.CategoryDto;
import br.com.like.services.CategoryService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final CategoryDto dto) {
        Category category = categoryService.create(dto.fromEntity());

        URI uri = Util.getUri(category.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody final CategoryDto dto, final Long id) {
        categoryService.update(dto.fromEntity(), id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findOne(@PathVariable final Long id) {
        Category category = categoryService.findOne(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<Category>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction
    ) {
        Page<Category> categories = categoryService.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping(value = "/associateProduct/{id}")
    public ResponseEntity<?> associateProduct(@Valid @RequestBody final CategoryDto dto, @PathVariable final Long id) {
        categoryService.associateProduct(dto.joinProduct(id));

        return ResponseEntity.noContent().build();
    }
}
