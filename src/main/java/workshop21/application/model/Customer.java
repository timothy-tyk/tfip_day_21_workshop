package workshop21.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
  private Integer id;
  private String company;
  private String firstName;
  private String lastName;
  private String jobTitle;
  private String address;
  private String city;
}
