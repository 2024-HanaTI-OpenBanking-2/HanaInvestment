package hanasecurities.hanasecurities.service;

import hanasecurities.hanasecurities.dto.AccountResponseDTO;
import hanasecurities.hanasecurities.entity.TestTable2;
import hanasecurities.hanasecurities.repository.TestTable2Repository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTable2Service {

  @Autowired
  private TestTable2Repository repository;

  //viewController test
  public List<TestTable2> findAll() {
    return repository.findAll();
  }

  public AccountResponseDTO checkBalance(int ci) {

    Optional<TestTable2> testTable2 = repository.findByCi(ci);

    if (testTable2.isPresent()) {
      return AccountResponseDTO.builder().ci(testTable2.get().getCi()).name(testTable2.get().getName()).build();
    } else {
      return AccountResponseDTO.builder().ci(0).name("Not Found").build();
    }
  }
}