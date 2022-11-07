package entities;

public class Filiere {

	
	private int id;
	private String code;
	private String libelle;
	private User user;
	
	
	public Filiere() {}
	
	public Filiere(int id, String code, String libelle) {
		
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
}
