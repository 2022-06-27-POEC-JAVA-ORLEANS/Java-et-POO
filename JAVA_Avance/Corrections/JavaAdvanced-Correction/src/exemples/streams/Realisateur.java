package exemples.streams;

public class Realisateur {
	
	private Long   id;
    private String nom;
    private String prenom;
    private int age;
    private String pays;
    
    public Realisateur() { 
    }
    
	public Realisateur(String nom, String prenom, int age, String pays) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.pays = pays;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getPays() {
		return pays;
	}



	public void setPays(String pays) {
		this.pays = pays;
	}



	@Override
	public String toString() {
		return getId() + " : " + getNom() + " " + getPrenom() + " - " + getAge() + " / " + getPays();
	}


	@Override
	public boolean equals(Object obj) {
		if(((Realisateur) obj).getId() != this.id) {
			return false;
		}
		
		return true;
	}
}
