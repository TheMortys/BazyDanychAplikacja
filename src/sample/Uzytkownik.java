package sample;

import java.sql.Date;

	public class Uzytkownik {
	private String login;
	private String password;
	private int userId;
	private String name;
	private String pesel;
	private String nip;
	private int telephone;
	private String email;
	private Date birthDate;
	
	
	public Uzytkownik(String login, String password, int userId, String name, String pesel, String nip, int telephone,
			String email, Date birthDate) {
		this.login = login;
		this.password = password;
		this.userId = userId;
		this.name = name;
		this.pesel = pesel;
		this.nip = nip;
		this.telephone = telephone;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	
	public String getLogin() {
		return login;
	}
	
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getUserId() {
		return userId;
	}
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPesel() {
		return pesel;
	}
	
	
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	
	public String getNip() {
		return nip;
	}
	
	
	public void setNip(String nip) {
		this.nip = nip;
	}
	
	
	public int getTelephone() {
		return telephone;
	}
	
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
