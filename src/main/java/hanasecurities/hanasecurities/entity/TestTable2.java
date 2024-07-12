package hanasecurities.hanasecurities.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "securities_account")
public class TestTable2 {

  @Id
  private int ci;
  private String name;
  // Getters and Setters
}