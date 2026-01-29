package web.shop.lab6va7.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.shop.lab6va7.dto.Report;
import web.shop.lab6va7.model.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    // ===== LAB6 – DSL =====
    List<Product> findByPriceBetween(double min, double max);

    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    // ===== LAB7 – JPQL =====
    @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double min, double max);

    @Query("FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    // ===== LAB7 – REPORT =====
    @Query("""
        SELECT 
            o.category AS group,
            SUM(o.price) AS sum,
            COUNT(o) AS count
        FROM Product o
        GROUP BY o.category
        ORDER BY SUM(o.price) DESC
    """)
    List<Report> getInventoryByCategory();
}
