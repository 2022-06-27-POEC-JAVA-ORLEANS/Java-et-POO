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
			String note = sc.nextLine(); 

			if (note.equals("q")) break;

			System.out.print("S�lectionner le nom de l'�l�ve pour cette note ? ");
			String nom = sc.nextLine();
			
			boolean foundedElev = false;
			for (int i=0; i<eleves.size(); i++) {
			//for (Eleve e: eleves) {
				if (eleves.get(i).getNom().equals(nom) ) {
					eleves.get(i).addNote(Double.parseDouble(note));
					foundedElev = true;
					break;
				}
		    }
			if (!foundedElev) {
				System.out.print("Prenom �l�ve ? ");
				String prenom = sc.nextLine();
				Eleve elevNew = new Eleve(nom, prenom);
				elevNew.addNote(Double.parseDouble(note));
				eleves.add(elevNew);
			}
		}
		

		// Second Time - Add choices to user
		while (true) {
			System.out.println("\nChoix ?\n"
					+ "a. Afficher toutes les notes\n"
					+ "b. Afficher les notes d'un �l�ve\n"
					+ "c. Afficher la moyenne des notes total\n"
					+ "q. Quitter le programme\r\n");
			String response = sc.nextLine();
			
			if (response.equals("q")) break;
			else if (response.equals("a")) getAllNotes();
			else if (response.equals("b")) getNoteByEleve();
			else if (response.equals("c")) getAvairageNote();
			else System.out.println("D�sol�, choix non reconnu");
		}

	}
	
	
	public static void getAllNotes() {
		for (int i=0; i<eleves.size(); i++) {
			System.out.println(eleves.get(i).toString());
		}
	}
	
	public static void getNoteByEleve() {
		System.out.print("Eleve recherch� ? ");
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
		System.out.println("Moyenne g�n�rale: " + sum/nbNotes);
	}

}