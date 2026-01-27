package web.shop.lab6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.shop.lab6.model.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {}
