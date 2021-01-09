package br.com.like.repositories;

import br.com.like.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT products FROM Product products where products.category.id = :id")
    List<Product> findProductsByCategory(@Param("id") final Long id);

    @Query("SELECT products FROM Product products where LOWER(products.name) LIKE %:text% or LOWER(products.category.name) LIKE %:text%")
    List<Product> findByProductsOrCategories(@Param("text") String text);
}
