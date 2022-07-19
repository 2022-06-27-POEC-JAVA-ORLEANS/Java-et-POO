package tp13;

public class User {
	
	protected String nom;
	protected String prenom;
	protected int age;
	protected Categorie categorie;
	
	public User() { }
	
	public User (String n, String p, int age) {
		this.nom = n;
		this.prenom = p;
		this.age = age;
		this.categorie = Categorie.UNDEFINED;
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
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
