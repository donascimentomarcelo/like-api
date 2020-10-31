package br.com.like.resources;

import br.com.like.domains.Product;
import br.com.like.dtos.ProductDto;
import br.com.like.services.ProductService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final ProductDto dto) {
        Product product = productService.create(dto.fromEntity());

        URI uri = Util.getUri(product.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody final ProductDto dto, final Long id) {
        productService.update(dto.fromEntity(), id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findOne(@PathVariable final Long id) {
        Product product = productService.findOne(id);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> categories = productService.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<Product>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction
    ) {
        Page<Product> categories = productService.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(categories);
    }
}
