package exercice_3_et_4;

import java.util.Scanner; 

public class Exo04 {
  public static void main(String args[]) {

    CompteBancaire compteJean = new CompteBancaire("A7652", 500, "05/03/2000", TypeCompte.COURANT);
    CompteBancaire compteFlorence = new CompteBancaire("B2311", -50, "01/02/2012", TypeCompte.COURANT);
    CompteBancaire comptePierre = new CompteBancaire("S2314", 7500, "01/02/1994", TypeCompte.EPARGNE);

    Banque banque = new Banque();
    banque.ajoutCompte(compteJean);
    banque.ajoutCompte(compteFlorence);
    banque.ajoutCompte(comptePierre);

    compteJean.start();
    compteFlorence.start();
    comptePierre.start();

   

    // Inteaction user
    Scanner sc = new Scanner(System.in);

    // Demander à l'utilisateur
    System.out.print("Numéro de compte: ");
    String numCompte = sc.nextLine();
    System.out.print("Date de compte: ");
    String dateCompte = sc.nextLine();
    System.out.print("Type compte (C-E ?): ");
    String typeCompte = sc.nextLine();

    // Cr�ation compte
    CompteBancaire newCompte = new CompteBancaire(numCompte, 0, dateCompte, TypeCompte.COURANT);
    if (typeCompte.equals("E")) {
      newCompte.setTypeDeCompte(TypeCompte.EPARGNE);
    }
    newCompte.start();
    banque.ajoutCompte(newCompte);
    System.out.println("Nombre de compte dans la banque: " + banque.getListeComptes().size());

    boolean encours = true;

    while (encours) {
      System.out.println("Quelle opération souhaitez vous faire ? Depot(D) - Retrait(R) - Cloture(C) - Virement(V) - Quitter(Q) ?");
      String response = sc.nextLine();
      int somme;
      switch(response) {
        case ("D"):
          System.out.print("Somme à déposer: ");
          somme = Integer.parseInt(sc.nextLine());
          newCompte.depot(somme);
          break;
        case ("R"): 
          System.out.print("Somme à retirer: ");
          somme = Integer.parseInt(sc.nextLine());
          newCompte.retrait(somme);
          break;
        case ("C"):
          newCompte.fermer();
          encours = false;
          break;
        case ("V"):
          System.out.print("Num�ro de compte bénéficiaire: ");
          String numBeneficiaire = sc.nextLine();
          System.out.print("Somme à virer: ");
          somme = Integer.parseInt(sc.nextLine());
          for (CompteBancaire c: banque.getListeComptes()) {
            if (c.getNumCompte().equals(numBeneficiaire)) {
              newCompte.virement(somme, c);
              break;
            }
          }
          break;
        case ("Q"): 
          encours = false;
          break;
      }
    }

    sc.close();

  }
}