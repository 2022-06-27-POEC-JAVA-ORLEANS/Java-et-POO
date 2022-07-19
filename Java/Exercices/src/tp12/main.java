package tp12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	
	static List<Eleve> eleves = new ArrayList<Eleve>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Init datas
		Eleve eleve1 = new Eleve("RATO", "Jean");
		Eleve eleve2 = new Eleve("MAMA", "Yann");
		Eleve eleve3 = new Eleve("LETEL", "Sofia");
		Eleve eleve4 = new Eleve("BENRA", "Yacine");
		Eleve eleve5 = new Eleve("GOLD", "Laure");
		eleves.add(eleve1); eleves.add(eleve2); eleves.add(eleve3); eleves.add(eleve4); eleves.add(eleve5);
	

		// First Time - Add notes and Students
		while (true) {
			System.out.print("Ajouter une nouvelle note ou quitter (q)");
			String response1 = sc.nextLine(); 

			if (response1.equals("q")) break;

			System.out.print("Sélectionner le nom de l'élève pour cette note ? ");
			String response2 = sc.nextLine();
			
			boolean foundedElev = false;
			for (int i=0; i<eleves.size(); i++) {
				if (eleves.get(i).getNom().equals(response2) ) {
					eleves.get(i).addNote(Double.parseDouble(response1));
					foundedElev = true;
					break;
				}
		    }
			if (!foundedElev) {
				System.out.print("Prenom élève ? "); String b = sc.nextLine();
				Eleve elevNew = new Eleve(response2, b);
				elevNew.addNote(Double.parseDouble(response1));
				eleves.add(elevNew);
			}
		}
		

		// Second Time - Add choices to user
		while (true) {
			System.out.println("\nChoix ?\n"
					+ "a. Afficher toutes les notes\n"
					+ "b. Afficher les notes d'une élève les notes\n"
					+ "c. Afficher la moyenne des notes total\n"
					+ "q. Quitter le programme\r\n");
			String response = sc.nextLine();
			
			if (response.equals("q")) break;
			else if (response.equals("a")) getAllNotes();
			else if (response.equals("b")) getNoteByEleve();
			else if (response.equals("c")) getAvairageNote();
			else System.out.println("Désolé, choix non reconnu");
		}

	}
	
	
	public static void getAllNotes() {
		for (int i=0; i<eleves.size(); i++) {
			System.out.println(eleves.get(i).toString());
		}
	}
	
	public static void getNoteByEleve() {
		System.out.print("Eleve recherché ? ");
		String response = sc.nextLine();
		for (int i=0; i<eleves.size(); i++) {
			if (eleves.get(i).getNom().equals(response) ) {
				System.out.println(eleves.get(i).toString());
				break;
			}
		}
	}
	
	public static void getAvairageNote() {
		double sum = 0.0;
		int nbNotes = 0;
		for (int i=0; i<eleves.size(); i++) {
			if (!eleves.get(i).getNotes().isEmpty()) {
				for(double note: eleves.get(i).getNotes()) {
					nbNotes++;
					sum += note;
				}
			}
		}
		System.out.println("Moyenne générale: " + sum/nbNotes);
	}

}