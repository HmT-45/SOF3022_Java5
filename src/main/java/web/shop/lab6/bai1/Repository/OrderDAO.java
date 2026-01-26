package web.shop.lab6.bai1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.shop.lab6.bai1.model.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {}
