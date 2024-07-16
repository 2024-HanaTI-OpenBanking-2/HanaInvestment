package hanasecurities.hanasecurities.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
@Table(name = "securities_balances")
public class SecuritiesBalance {

  @Column(name = "account_id", length = 200, nullable = false)
  private String accountId;

  @Column(name = "current_quantity", precision = 10, scale = 2)
  private BigDecimal currentQuantity;

  @Column(name = "purchase_price", precision = 10, scale = 2)
  private BigDecimal purchasePrice;

  @Column(name = "fluctuation_rate", precision = 10, scale = 2)
  private BigDecimal fluctuationRate;

  @Column(name = "evaluation_profit_loss", precision = 10, scale = 2)
  private BigDecimal evaluationProfitLoss;

  @Id
  @Column(name = "stock_code", length = 20, nullable = false)
  private String stockCode;

  @Column(name = "prdt_name", length = 200, nullable = false)
  private String stockName;
  // Getters and Setters
}
