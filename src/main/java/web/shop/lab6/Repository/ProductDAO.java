package web.shop.lab6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.shop.lab6.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {}
