package web.shop.lab6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.shop.lab6.model.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {}