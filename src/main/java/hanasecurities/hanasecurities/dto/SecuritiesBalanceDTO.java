package hanasecurities.hanasecurities.dto;


import java.math.BigDecimal;
import lombok.Data;


@Data
public class SecuritiesBalanceDTO {
  private String accountId;
  private BigDecimal currentQuantity;
  private BigDecimal purchasePrice;
  private BigDecimal fluctuationRate;
  private BigDecimal evaluationProfitLoss;
  private String stockCode;
  private String stockName;

  // Getters and Setters
}
