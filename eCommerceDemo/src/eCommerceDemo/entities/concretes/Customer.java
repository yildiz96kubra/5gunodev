package eCommerceDemo.entities.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.entities.abstracts.IEntity;

public class Customer implements IEntity {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String passwaord;
	private boolean activationStatus;

	public Customer() {

	}

	public Customer(int id, String firstName, String lastName, String email, String passwaord,
			boolean activationStatus) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwaord = passwaord;
		this.activationStatus = activationStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches())
			this.email = email;

		else
			System.out.println("Girilen Email bilgisi yanlýþtýr.Lütfen kontrol ediniz " + email);
	}

	public String getPasswaord() {
		return passwaord;
	}

	public void setPasswaord(String passwaord) {
		this.passwaord = passwaord;
	}

	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

}
