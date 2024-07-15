package hanasecurities.hanasecurities.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "securities_customers")
public class Customer {

  @Id
  private String customerId;
  private String customerPassword;
  private String name;
  private String phone;
  private String address;
  private String email;
  private String userType;
  private java.sql.Timestamp registrationDate;
  private String ci;

  // Getters and Setters
}