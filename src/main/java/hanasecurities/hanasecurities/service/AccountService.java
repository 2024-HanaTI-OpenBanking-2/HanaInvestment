package hanasecurities.hanasecurities.service;

import hanasecurities.hanasecurities.dto.AccountInfoDto;
import hanasecurities.hanasecurities.entity.Customer;
import hanasecurities.hanasecurities.repository.AccountRepository;
import hanasecurities.hanasecurities.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

  private final AccountRepository accountRepository;
  private final CustomerRepository customerRepository;

  public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
    this.accountRepository = accountRepository;
    this.customerRepository = customerRepository;
  }

  public List<AccountInfoDto> findAccountsByCi(String ci) {
    Customer customer = customerRepository.findByCi(ci);
    if (customer != null) {
      return accountRepository.findByCustomerId(customer.getCustomerId())
          .stream()
          .map(account -> new AccountInfoDto(account.getAccountId(), account.getFinancialCompany(), account.getAccountNumber(), account.getCash(), account.getTotalAssets()))
          .collect(Collectors.toList());
    }
    return List.of();  // Return an empty list if customer is not found
  }
}