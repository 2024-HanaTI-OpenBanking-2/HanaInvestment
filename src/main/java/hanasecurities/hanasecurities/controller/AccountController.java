package hanasecurities.hanasecurities.controller;

import hanasecurities.hanasecurities.dto.AccountResponseDTO;
import hanasecurities.hanasecurities.service.TestTable2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountinfo")
public class AccountController {

  private final TestTable2Service testTable2Service;

  @Autowired
  public AccountController(TestTable2Service testTable2Service) {
    this.testTable2Service = testTable2Service;
  }

  @GetMapping("/list")
  public ResponseEntity<AccountResponseDTO> checkBalance(@RequestParam int ci) {
    return ResponseEntity.ok(testTable2Service.checkBalance(ci));
  }
}
