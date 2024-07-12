package hanasecurities.hanasecurities.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class AccountResponseDTO {
  private int ci;
  private String name;
}

