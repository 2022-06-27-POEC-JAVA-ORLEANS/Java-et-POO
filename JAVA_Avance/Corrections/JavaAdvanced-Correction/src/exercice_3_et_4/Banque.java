package exercice_3_et_4;

import java.util.ArrayList;
import java.util.Iterator;

public class Banque {

	  private ArrayList<CompteBancaire> listeComptes = new ArrayList<CompteBancaire>();
	  
	  public Banque() {
	  }
	
	  public void ajoutCompte(CompteBancaire c) {
	    this.listeComptes.add(c);
	  }
	
	
	  public ArrayList<CompteBancaire> getListeComptes() {
	    return this.listeComptes;
	  }
	
	  public void setListeComptes(ArrayList<CompteBancaire> listeComptes) {
	    this.listeComptes = listeComptes;
	  }

	@Override
	public String toString() {
		String text;
		
		text = "Banque XXX - Liste des comptes : \n";
	    Iterator<CompteBancaire> it = getListeComptes().iterator();
	    while(it.hasNext()) {
	    	text += it.next() + "\n";
	    }
		
		return text;
	}

	  
}