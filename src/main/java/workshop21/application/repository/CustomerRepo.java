package workshop21.application.repository;
import java.util.List;
import workshop21.application.model.Customer;
import workshop21.application.model.Order;


public interface CustomerRepo {
  List<Customer> getAllCustomers(Integer limit, Integer offset);
  Customer getCustomerById(Integer id);
  List<Order> getCustomerOrder(Integer id);
}
