package eCommerceDemo.Core;

import eCommerceDemo.GoogleAuth.GoogleAuthManager;
import eCommerceDemo.dataAccess.abstracts.ICustomerDao;

public class IGoogleAuthManagerAdapter implements AuthService {
	

	@Override
	public void Register(int id, String firstName, String lastName, String email, String password) {
		GoogleAuthManager googleAuthManager=new GoogleAuthManager();
		googleAuthManager.register(id, firstName, lastName, email, password);
		
	}

	@Override
	public void Login(String email, String password) {
		GoogleAuthManager googleAuthManager=new GoogleAuthManager();
		googleAuthManager.login(email, password);		
	}

}
