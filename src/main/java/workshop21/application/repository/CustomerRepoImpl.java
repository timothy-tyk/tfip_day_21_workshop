package workshop21.application.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import workshop21.application.model.Customer;
import workshop21.application.model.Order;
import workshop21.application.service.Queries;

@Repository
public class CustomerRepoImpl implements CustomerRepo{

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<Customer> getAllCustomers(Integer limit, Integer offset) {
    List<Customer> customerList = jdbcTemplate.query(Queries.getAllCustomersSQL, BeanPropertyRowMapper.newInstance(Customer.class), limit,offset);
    return customerList;
  }

  @Override
  public Customer getCustomerById(Integer id) {
    Customer customer = jdbcTemplate.queryForObject(Queries.getCustomerSQL, BeanPropertyRowMapper.newInstance(Customer.class),id);
    return customer;
  }

  @Override
  public List<Order> getCustomerOrder(Integer id) {
    List<Order> orderList = jdbcTemplate.query(Queries.getCustomerOrderSQL, BeanPropertyRowMapper.newInstance(Order.class), id);
    return orderList;
  }}
