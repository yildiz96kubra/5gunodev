package eCommerceDemo.GoogleAuth;


public class GoogleAuthManager  {

	public void register(int id, String firstName, String lastName, String email, String password) {
      System.out.println("Google hesab�n�z ile kay�t ba�ar�l� �ekilde yap�lm��t�r" + email);		
	}

	public void login(String email, String password) {
	      System.out.println("Google hesab�n�z ile ba�ar�l� �ekilde giri� i�lemi yap�lm��t�r" + email);		
		
	}
 
}
