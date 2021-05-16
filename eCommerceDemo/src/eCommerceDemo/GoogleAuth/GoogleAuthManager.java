package eCommerceDemo.GoogleAuth;


public class GoogleAuthManager  {

	public void register(int id, String firstName, String lastName, String email, String password) {
      System.out.println("Google hesabýnýz ile kayýt baþarýlý þekilde yapýlmýþtýr" + email);		
	}

	public void login(String email, String password) {
	      System.out.println("Google hesabýnýz ile baþarýlý þekilde giriþ iþlemi yapýlmýþtýr" + email);		
		
	}
 
}
