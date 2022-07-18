package model;

public class Salarie {
	
	protected int id;
	protected String nom;
	protected String prenom;
	protected double salaire = 1645.58;
	protected String codeResto;
	
	
	public Salarie() {};
	
	public Salarie(String nom, String prenom, double salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	};
	
	public Salarie(int id, String nom, String prenom, double salaire) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	};

	
	
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
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getCodeResto() {
		return codeResto;
	}
	public void setCodeResto(String codeResto) {
		this.codeResto = codeResto;
	}
	
}
