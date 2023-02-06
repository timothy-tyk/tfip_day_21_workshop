package workshop21.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import workshop21.application.model.Customer;
import workshop21.application.model.Order;
import workshop21.application.repository.CustomerRepoImpl;

@Service
public class CustomerService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  CustomerRepoImpl custRepoImpl;

  public ResponseEntity<List<Customer>> getAllCustomers(Integer offset, Integer limit){
    List<Customer> customerList = custRepoImpl.getAllCustomers(limit, offset);
    if(customerList != null){
      return new ResponseEntity<List<Customer>>(customerList, HttpStatus.FOUND);
    }
    else{
      return new ResponseEntity<>(null, HttpStatus.FOUND);
    }
  }

  public ResponseEntity<Customer> getCustomerById(Integer id) {
    try{
      Customer customer = custRepoImpl.getCustomerById(id);
      return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);

    }catch (EmptyResultDataAccessException e){
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<List<Order>> getCustomerOrders(Integer id){
    try{
      List<Order> orderList = custRepoImpl.getCustomerOrder(id);
      return new ResponseEntity<List<Order>>(orderList, HttpStatus.FOUND);
    }catch(EmptyResultDataAccessException e){
      return new ResponseEntity<>(null, HttpStatus.FOUND);
    }
  }
}
