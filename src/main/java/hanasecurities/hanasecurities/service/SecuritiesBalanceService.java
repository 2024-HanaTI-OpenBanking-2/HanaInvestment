package hanasecurities.hanasecurities.service;


import hanasecurities.hanasecurities.dto.SecuritiesBalanceDTO;
import hanasecurities.hanasecurities.entity.SecuritiesBalance;
import hanasecurities.hanasecurities.repository.SecuritiesBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecuritiesBalanceService {

  @Autowired
  private SecuritiesBalanceRepository repository;

  public List<SecuritiesBalanceDTO> findAllBalances() {
    return repository.findAll().stream()
        .map(this::convertEntityToDTO)
        .collect(Collectors.toList());
  }

  private SecuritiesBalanceDTO convertEntityToDTO(SecuritiesBalance balance) {
    SecuritiesBalanceDTO dto = new SecuritiesBalanceDTO();
    dto.setAccountId(balance.getAccountId());
    dto.setCurrentQuantity(balance.getCurrentQuantity());
    dto.setPurchasePrice(balance.getPurchasePrice());
    dto.setFluctuationRate(balance.getFluctuationRate());
    dto.setEvaluationProfitLoss(balance.getEvaluationProfitLoss());
    dto.setStockCode(balance.getStockCode());
    dto.setStockName(balance.getStockName());
    return dto;
  }
}
