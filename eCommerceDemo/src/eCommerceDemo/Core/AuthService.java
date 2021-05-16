package eCommerceDemo.Core;

public interface AuthService {
	void Register(int id, String firstName, String lastName, String email, String password);

	void Login(String email, String password);
}
