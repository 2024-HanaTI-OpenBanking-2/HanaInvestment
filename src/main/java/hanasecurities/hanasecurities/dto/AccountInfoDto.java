package hanasecurities.hanasecurities.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountInfoDto {

  private String accountId;
  private String financialCompany;
  private String accountNumber;
  private BigDecimal cash;
  private BigDecimal totalAssets;

  // Getters and Setters
}