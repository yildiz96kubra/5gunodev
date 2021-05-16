package eCommerceDemo;

import eCommerceDemo.Core.IGoogleAuthManagerAdapter;
import eCommerceDemo.business.concretes.CustomerManager;
import eCommerceDemo.dataAccess.concretes.CustomerDao;
import eCommerceDemo.entities.concretes.Customer;
import eCommerceDemo.entities.concretes.Login;

public class Main {

	public static void main(String[] args) {

		CustomerManager customerManager = new CustomerManager(new CustomerDao(), new IGoogleAuthManagerAdapter());
		
		Customer customer = new Customer(1, "Kübra", "Yýldýz", null, "123456", true);
		customer.setEmail("kbryldz@gmail.com");
		customerManager.register(customer, "websitesi"); // baþarýlý kayýt
		customerManager.chechkActivision();


		Customer customer1 = new Customer(1, "Kübra", "Yýldýz", null, "123456", true);
		customer1.setEmail("123@com");
		customerManager.register(customer1, "websitesi");// email kontrolüne takýlan kayýt

		Customer customer2 = new Customer(1, "Kübra", "Yýldýz", null, "12345", true);
		customer2.setEmail("123@gmail.com");
		customerManager.register(customer2, "websitesi");// þifre kontrolüne takýlan kayýt
		
		Customer customer3 = new Customer(1, "Kübra", "Yýldýz", null, "123456", true);
		customer3.setEmail("kbryldz@gmail.com");
		customerManager.register(customer3, "google"); // baþarýlý kayýt
		customerManager.chechkActivision();

		
		System.out.println("");
		
		Login login=new Login(null,null);	//þifre ve mail boþ	
		Login login1=new Login("",null);//þifre alaný boþ
		Login login2=new Login(null,"");//mail alaný boþ
		Login login3=new Login("kbryldz6@gmail.com","123456");//baþarýlý giriþ
		Login login4=new Login("kbryldz6@gmail.com","1234567");//hatalý þifre
		Login login5=new Login("kbryld@gmail.com","123456");//sistemde olmayan mail adresi
		customerManager.login(login, "websitesi");
		customerManager.login(login1, "websitesi");
		customerManager.login(login2, "websitesi");
		customerManager.login(login3, "websitesi");
		customerManager.login(login4, "websitesi");
		customerManager.login(login5, "websitesi");
		customerManager.login(login5, "google"); 
		
	}

}
