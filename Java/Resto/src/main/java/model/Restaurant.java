package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	protected String code;
	protected String nom;
	protected String adresse;
	protected int nbTables;
	protected boolean statut;
	protected List<Salarie> salaries = new ArrayList<Salarie>();
	
	
	public Restaurant() { }
	
	public Restaurant (String code, String nom, String adresse, int nbTables, boolean statut) {
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
		this.nbTables = nbTables;
		this.statut = statut;
	}
	
	

	public void addSalarie(Salarie salarie) {
		this.salaries.add(salarie);
	}
	
	@Override
	public String toString() {
		String msg = this.nom + " (" + this.code + "): ";
		for (Salarie s: this.salaries) {
			msg += s.getNom() +" "+ s.getPrenom() + " ";
		}
		return msg;
	}
	
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNbTables() {
		return nbTables;
	}
	public void setNbTables(int nbTables) {
		this.nbTables = nbTables;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public List<Salarie> getSalaries() {
		return salaries;
	}
	public void setSalaries(List<Salarie> salaries) {
		this.salaries = salaries;
	}
	
}
