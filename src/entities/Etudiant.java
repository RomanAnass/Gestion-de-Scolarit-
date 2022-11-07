package entities;

public class Etudiant {
	
	private int id ; 
	private String nom;
	private String prenom;
	private String cne;
	private Filiere filiere;
	private User user;
	
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	
	public Etudiant(int id, String nom, String prenom, String cne, Filiere f) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.filiere= f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Etudiant id : " + id + "\nnom : " + nom + "\nprenom : " + prenom + "\ncne : " + cne + "\nFilliere : " + filiere;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	 

}
