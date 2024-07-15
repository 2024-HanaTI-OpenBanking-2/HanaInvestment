package hanasecurities.hanasecurities.controller;


import hanasecurities.hanasecurities.dto.SecuritiesBalanceDTO;
import hanasecurities.hanasecurities.service.SecuritiesBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balances")
public class SecuritiesBalanceController {

  @Autowired
  private SecuritiesBalanceService service;

  @GetMapping
  public List<SecuritiesBalanceDTO> getAllBalances() {
    return service.findAllBalances();
  }
}