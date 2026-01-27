package web.shop.lab6.bai1_2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.shop.lab6.bai1_2.model.Account;

public interface AccountDAO extends JpaRepository<Account, String> {}