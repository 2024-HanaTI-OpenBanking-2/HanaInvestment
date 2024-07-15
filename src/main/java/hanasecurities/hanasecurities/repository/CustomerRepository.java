package hanasecurities.hanasecurities.repository;

import hanasecurities.hanasecurities.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
  Customer findByCi(String ci);
}
