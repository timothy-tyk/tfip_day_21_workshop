package workshop21.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import workshop21.application.service.CustomerService;
import workshop21.application.model.Customer;
import workshop21.application.model.Order;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

  @Autowired
  CustomerService custSvc;

  @GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(name ="offset", required=false) Integer offset, @RequestParam(name="limit",required=false) Integer limit){
    if(offset==null || offset.toString().isEmpty()) offset = 0;
    if(limit==null || limit.toString().isEmpty()) limit = 5;
    ResponseEntity<List<Customer>> response = custSvc.getAllCustomers(offset, limit);
    return response;
  }

  @GetMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
    ResponseEntity<Customer> response = custSvc.getCustomerById(id);
    return response;
  }

  @GetMapping(path = "/customer/{id}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Integer id){
    ResponseEntity<List<Order>> response = custSvc.getCustomerOrders(id);
    return response;
  }
}
