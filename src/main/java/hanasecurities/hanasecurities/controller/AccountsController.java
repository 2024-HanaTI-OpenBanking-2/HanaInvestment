package hanasecurities.hanasecurities.controller;

import hanasecurities.hanasecurities.dto.AccountCiResponseDTO;
import hanasecurities.hanasecurities.dto.AccountInfoDto;
import hanasecurities.hanasecurities.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accountinfo")
public class AccountsController {

  private final AccountService accountService;


  public AccountsController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/list")
  public ResponseEntity<List<AccountInfoDto>> getAccountList(@RequestBody AccountCiResponseDTO accountCiResponseDTO) {
    List<AccountInfoDto> response = accountService.findAccountsByCi(accountCiResponseDTO.getCi());
    return ResponseEntity.ok(response);
  }

}
