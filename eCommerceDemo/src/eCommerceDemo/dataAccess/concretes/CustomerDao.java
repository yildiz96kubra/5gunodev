package eCommerceDemo.dataAccess.concretes;

import java.util.List;
import java.util.ArrayList;

import eCommerceDemo.dataAccess.abstracts.ICustomerDao;
import eCommerceDemo.entities.concretes.Customer;

public class CustomerDao implements ICustomerDao {

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub

		Customer customer = new Customer(1, "K�bra", "Y�ld�z", "kbryldz1@gmail.com", "123456", true);
		Customer customer1 = new Customer(2, "K�bra", "Y�ld�z", "kbryldz2@gmail.com", "123456", true);
		Customer customer2 = new Customer(3, "K�bra", "Y�ld�z", "kbryldz3@gmail.com", "123456", true);
		Customer customer3 = new Customer(4, "K�bra", "Y�ld�z", "kbryldz4@gmail.com", "123456", true);
		Customer customer4 = new Customer(5, "K�bra", "Y�ld�z", "kbryldz5@gmail.com", "123456", true);
		Customer customer5 = new Customer(6, "K�bra", "Y�ld�z", "kbryldz6@gmail.com", "123456", true);

		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(customer);
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		customerList.add(customer4);
		customerList.add(customer5);

		return customerList;
	}

}
