package hanasecurities.hanasecurities.repository;



import hanasecurities.hanasecurities.entity.SecuritiesBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecuritiesBalanceRepository extends JpaRepository<SecuritiesBalance, String> {
}