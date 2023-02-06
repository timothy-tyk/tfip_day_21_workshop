package workshop21.application.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import workshop21.application.model.Customer;
import workshop21.application.model.Order;

@Service
public class CustomerService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public ResponseEntity<List<Customer>> getAllCustomers(Integer offset, Integer limit){
    List<Customer> customerList = jdbcTemplate.query(Queries.getAllCustomersSQL, BeanPropertyRowMapper.newInstance(Customer.class), limit,offset);
    if(customerList != null){
      return new ResponseEntity<List<Customer>>(customerList, HttpStatus.FOUND);
    }
    else{
      return new ResponseEntity<>(null, HttpStatus.FOUND);
    }
  }

  public ResponseEntity<Customer> getCustomerById(Integer id) {
    try{
      Customer customer = jdbcTemplate.queryForObject(Queries.getCustomerSQL, BeanPropertyRowMapper.newInstance(Customer.class),id);
      return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);

    }catch (EmptyResultDataAccessException e){
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<List<Order>> getCustomerOrders(Integer id){
    try{
      List<Order> orderList = jdbcTemplate.query(Queries.getCustomerOrderSQL, BeanPropertyRowMapper.newInstance(Order.class), id);
      return new ResponseEntity<List<Order>>(orderList, HttpStatus.FOUND);
    }catch(EmptyResultDataAccessException e){
      return new ResponseEntity<>(null, HttpStatus.FOUND);
    }
  }
}
