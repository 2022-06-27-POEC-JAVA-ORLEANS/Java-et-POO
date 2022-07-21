package tp16;

public class Sport {
	
	// Attributs
	protected int id;
	protected String nom;
	protected Type type;
	protected boolean actif;
	protected String description;
	
	
	
	// Constructeurs
	public Sport() { };
	
	public Sport(String nom, Type type, boolean actif, String desc) { 
		this.nom = nom;
		this.type = type;
		this.actif = actif;
		this.description = desc;
	};
	
	
	// Méthodes
	public void afficher() {
		System.out.println(this.nom + " (" + this.description + ")");
	}

	
	// Getters and Setters
	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
