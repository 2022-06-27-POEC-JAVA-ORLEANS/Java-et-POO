package exercice_3_et_4;

import java.util.Iterator;

public class Exo03_2 {
  public static void main(String args[]) {

    CompteBancaire compteJean = new CompteBancaire("A7652", 500, "05/03/2000", TypeCompte.COURANT);
    CompteBancaire compteFlorence = new CompteBancaire("B2311", -50, "01/02/2012", TypeCompte.COURANT);
    CompteBancaire comptePierre = new CompteBancaire("S2314", 7500, "01/02/1994", TypeCompte.EPARGNE);

    Banque banque = new Banque();
    banque.ajoutCompte(compteJean);
    banque.ajoutCompte(compteFlorence);
    banque.ajoutCompte(comptePierre);

    Banque banque2 = new Banque();
    banque.ajoutCompte(compteJean);
    banque.ajoutCompte(compteFlorence);
    banque.ajoutCompte(comptePierre);
    compteJean.start();
    compteFlorence.start();
    comptePierre.start();

    // Tests
    compteJean.depot(50);
    compteJean.retrait(600);
    comptePierre.virement(55, compteJean);
    
    
    Iterator<CompteBancaire> it = banque.getListeComptes().iterator();
    while(it.hasNext()) {
    	System.out.println(it.next());
    }
    
    System.out.println(banque.getListeComptes());
    
    System.out.println(banque);
    System.out.println(banque2);
    System.out.println(banque);
    
    System.out.println(comptePierre.getTypeDeCompte());
  }
}