package web.shop.lab6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.shop.lab6.model.Account;

public interface AccountDAO extends JpaRepository<Account, String> {}