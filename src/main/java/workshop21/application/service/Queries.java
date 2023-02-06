package workshop21.application.service;

public class Queries {
  public static final String getAllCustomersSQL = "SELECT * FROM customers LIMIT ? OFFSET ?";
  public static final String getCustomerSQL = "SELECT * FROM customers WHERE id = ?";
  public static final String getCustomerOrderSQL = "SELECT orders.* FROM orders INNER JOIN customers ON customer_id = ?";
}
