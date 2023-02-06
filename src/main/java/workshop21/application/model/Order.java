package workshop21.application.model;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  private Integer id;
  private Integer employeeId;
  private Date orderDate;
  private Integer shipperId;
  private String shipName;
  private String shipAddress;
  private String shipCity;
}
