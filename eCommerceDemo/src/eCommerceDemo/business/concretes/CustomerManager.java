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
								+ "Kullan�c�n�n sisteme ba�ar�l� �ekilde kay�t� yap�ld�");
						sendActivasionEmail(customer);
					} else
						System.out.println(
								"Bu email ile daha �nceden kay�t olu�turulmu�tur �ifremi unuttum se�ene�i ile devam edebilirsiniz!");

				} else
					System.out.println("Ge�erli bir Email adresi giriniz");
			} else
				System.out.println("�ifre 6 karakterden uzun olmal�");
		} else
			System.out.println("�sim ve Soyisim en az 2 karakterden olu�mal�d�r");
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
						System.out.println("Kullan�c� sisteme ba�ar�l� �ekilde giri� yapt�");
					else
						System.out.println("Hatal� �ifre giri�i yapt�n�z");
				} else
					System.out.println("Girilen Mail adresi ile sisteme kay�tl� Email bulunamad�");
			} else
				System.out.println("�ifre giri�i yap�n�z");
		} else
			System.out.println("Email adresinizi yaz�n�z");
		}
		else if(auth=="google") {
			authservice.Login(login.getEmail(), login.getPasswaord());
		}
	}

	@Override
	public void sendActivasionEmail(Customer customer) {
System.out.println( customer.getEmail()+" adresine aktivasyon maili g�nderilmi�tir.");		
	}

	@Override
	public void chechkActivision() {
		System.out.println( "Aktivasyonunuz ba�ar�yla sa�lanm��t�r al��veri�e ba�layabilirsiniz");		

	}
	

}
