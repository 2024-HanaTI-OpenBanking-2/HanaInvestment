package hanasecurities.hanasecurities.repository;

import hanasecurities.hanasecurities.entity.TestTable2;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestTable2Repository extends JpaRepository<TestTable2, Integer> {

  Optional<TestTable2> findByCi(int ci);
}