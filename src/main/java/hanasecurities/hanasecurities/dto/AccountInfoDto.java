package hanasecurities.hanasecurities.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountInfoDto {

  private String accountId;
  private String financialCompany;
  private String accountNumber;
  private BigDecimal cash;
  private BigDecimal totalAssets;

  public AccountInfoDto(String accountId, String financialCompany, String accountNumber, BigDecimal cash, BigDecimal totalAssets) {
    this.accountId = accountId;
    this.financialCompany = financialCompany;
    this.accountNumber = accountNumber;
    this.cash = cash;
    this.totalAssets = totalAssets;
  }

  // Getters and Setters
}