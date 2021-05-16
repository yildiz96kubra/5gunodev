package eCommerceDemo.dataAccess.abstracts;


import java.util.List;

import eCommerceDemo.entities.concretes.Customer;

public interface ICustomerDao {
  
    Customer get(int id);
    List<Customer> getAll();
}
