package web.shop.lab6va7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.shop.lab6va7.model.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {}