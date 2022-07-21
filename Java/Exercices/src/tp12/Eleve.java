package tp12;

import java.util.ArrayList;
import java.util.List;

public class Eleve {
	
	protected String nom;
	protected String prenom;
	protected List<Double> notes = new ArrayList<Double>();
	
	// Constructors 
	public Eleve() {}
	
	public Eleve(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	// Methods
	public void addNote(Double note) {
		this.notes.add(note);
	}
	
	@Override
	public String toString() {
		return this.nom + " " + this.prenom + " a " + this.notes.size() + " notes: " + this.notes;
	}
	
	public double getAvairage() {
		double av = 0.0;
		for (int i=0; i<notes.size(); i++) {
			av += (double) this.notes.get(i);
		}
		/*for (Double i: this.notes) {
			av += (double) i;
		}*/
		return av/notes.size();
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

	public List<Double> getNotes() {
		return notes;
	}

	public void setNotes(List<Double> notes) {
		this.notes = notes;
	}
	
}



