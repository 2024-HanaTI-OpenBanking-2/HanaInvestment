package hanasecurities.hanasecurities.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "securities_hana_accounts")
public class Account {

  @Id
  private String accountId;
  private String customerId;
  private String financialCompany;
  private String accountNumber;
  private BigDecimal cash;
  private BigDecimal totalAssets;

  // Getters and Setters
}