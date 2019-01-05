package sample;

import java.sql.Date;

public class KontoPracownika extends Uzytkownik {

	private String stanowisko;

	public KontoPracownika(String login, String password, int userId, String name, String pesel, String nip,
			int telephone, String email, Date birthDate, String stanowisko) {
		super(login, password, userId, name, pesel, nip, telephone, email, birthDate);
		this.stanowisko = stanowisko;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	
}
