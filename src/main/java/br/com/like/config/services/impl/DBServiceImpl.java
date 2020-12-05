package br.com.like.config.services.impl;

import br.com.like.config.services.DBService;
import br.com.like.domains.Category;
import br.com.like.domains.Product;
import br.com.like.repositories.CategoryRepository;
import br.com.like.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBServiceImpl implements DBService {

    private final String desc = "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void instantiateTestDatabase() throws ParseException {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category c1 = new Category(1L, "Decoracao");
        Category c2 = new Category(2L,"Escritorio");
        Category c3 = new Category(3L,"Cama mesa e banho");
        Category c4 = new Category(4L, "Eletronicos");

        Product p1 = new Product(1L, "Computador", 2000.00, desc, 20);
        Product p2 = new Product(2L,"Impressora", 800.00, desc, 10);
        Product p3 = new Product(3L,"Mouse", 80.00, desc, 80);
        Product p4 = new Product(4L,"Mesa de escritorio", 300.00, desc, 40);
        Product p5 = new Product(5L,"Toalha", 30.00, desc, 13);
        Product p6 = new Product(6L,"Colcha", 200.00, desc, 4);
        Product p7 = new Product(7L,"TV true color", 1200.00, desc, 7);
        Product p8 = new Product(8L,"Rocadeira", 800.00, desc, 20);
        Product p9 = new Product(9L,"Abajour", 100.00, desc, 20);
        Product p0 = new Product(10L,"Pendente", 180.00, desc, 10);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p0));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        c1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        c2.getProducts().addAll(Arrays.asList(p4, p5, p6));
        c3.getProducts().addAll(Arrays.asList(p7, p8, p9));
        c4.getProducts().addAll(Arrays.asList(p0, p1, p2));

        p1.getCategories().addAll(Arrays.asList(c1, c4));
        p2.getCategories().addAll(Arrays.asList(c1, c4));
        p3.getCategories().add(c1);

        p4.getCategories().add(c2);
        p5.getCategories().add(c2);
        p6.getCategories().add(c2);

        p7.getCategories().add(c3);
        p8.getCategories().add(c3);
        p9.getCategories().add(c3);

        p0.getCategories().add(c4);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p0));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
    }
}
