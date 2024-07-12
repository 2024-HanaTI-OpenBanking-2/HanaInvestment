package hanasecurities.hanasecurities.controller;


import hanasecurities.hanasecurities.entity.TestTable2;
import hanasecurities.hanasecurities.service.TestTable2Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ViewController {

  private final TestTable2Service testTable2Service;

  @Autowired
  public ViewController(TestTable2Service testTable2Service) {
    this.testTable2Service = testTable2Service;
  }

  @GetMapping("/greeting")
  public String greeting(Model model) {
    model.addAttribute("records", testTable2Service.findAll());
    return "greeting";
  }


}
