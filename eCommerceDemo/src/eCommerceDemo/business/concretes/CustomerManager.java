package eCommerceDemo.business.concretes;

import eCommerceDemo.Core.AuthService;
import eCommerceDemo.business.abstracts.ICustomerService;
import eCommerceDemo.dataAccess.abstracts.ICustomerDao;
import eCommerceDemo.entities.concretes.Customer;
import eCommerceDemo.entities.concretes.Login;

public class CustomerManager implements ICustomerService {
    
	private ICustomerDao customerDao;
	private AuthService authservice;

	public CustomerManager(ICustomerDao customerDao, AuthService authService) {
		super();
		this.customerDao = customerDao;
		this.authservice = authService;
	}

	@Override
	public void register(Customer customer,String auth) {
		if (auth == "websitesi") {
		var customerList = this.customerDao.getAll();

		if (customer.getFirstName().length() >= 2 && customer.getLastName().length() >= 2) {
			if (customer.getPasswaord().length() >= 6) {
				if (customer.getEmail() != null) {
					if (!customerList.stream().anyMatch(x -> x.getEmail() == customer.getEmail())) {
						System.out.println(customer.getFirstName() + " " + customer.getLastName() + " "
								+ "Kullanýcýnýn sisteme baþarýlý þekilde kayýtý yapýldý");
						sendActivasionEmail(customer);
					} else
						System.out.println(
								"Bu email ile daha önceden kayýt oluþturulmuþtur þifremi unuttum seçeneði ile devam edebilirsiniz!");

				} else
					System.out.println("Geçerli bir Email adresi giriniz");
			} else
				System.out.println("Þifre 6 karakterden uzun olmalý");
		} else
			System.out.println("Ýsim ve Soyisim en az 2 karakterden oluþmalýdýr");
		}
		else if(auth=="google") {
			authservice.Register(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPasswaord());
		}
	}

	@Override
	public void login(Login login,String auth) {
		if(auth == "websitesi") {
		if (login.getEmail() != null) {
			if (login.getPasswaord() != null) {
				var customerList = this.customerDao.getAll();
				var checkCustomerEmail = customerList.stream().filter(x -> x.getEmail() == login.getEmail())
						.findFirst();
				if (!checkCustomerEmail.isEmpty()) {
					if (checkCustomerEmail.get().getPasswaord() == login.getPasswaord())
						System.out.println("Kullanýcý sisteme baþarýlý þekilde giriþ yaptý");
					else
						System.out.println("Hatalý þifre giriþi yaptýnýz");
				} else
					System.out.println("Girilen Mail adresi ile sisteme kayýtlý Email bulunamadý");
			} else
				System.out.println("Þifre giriþi yapýnýz");
		} else
			System.out.println("Email adresinizi yazýnýz");
		}
		else if(auth=="google") {
			authservice.Login(login.getEmail(), login.getPasswaord());
		}
	}

	@Override
	public void sendActivasionEmail(Customer customer) {
System.out.println( customer.getEmail()+" adresine aktivasyon maili gönderilmiþtir.");		
	}

	@Override
	public void chechkActivision() {
		System.out.println( "Aktivasyonunuz baþarýyla saðlanmýþtýr alýþveriþe baþlayabilirsiniz");		

	}
	

}
