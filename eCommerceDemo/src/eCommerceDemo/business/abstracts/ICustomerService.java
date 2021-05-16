package eCommerceDemo.business.abstracts;



import eCommerceDemo.entities.concretes.Customer;
import eCommerceDemo.entities.concretes.Login;

public interface ICustomerService {
       void register (Customer customer, String auth);
       void login (Login login,String auth );
      void sendActivasionEmail(Customer customer);
      void chechkActivision();
}
