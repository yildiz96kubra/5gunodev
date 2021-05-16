package eCommerceDemo.entities.concretes;

public class Login {
	private String email;
	private String passwaord;

	public Login(String email, String passwaord) {
		super();
		this.email = email;
		this.passwaord = passwaord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswaord() {
		return passwaord;
	}

	public void setPasswaord(String passwaord) {
		this.passwaord = passwaord;
	}

}
