import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class tp11 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> mapNotes = new HashMap<String, Integer>();

		while (true) {
			System.out.print("Quel est votre nom (ou quitter avec q):");
			String nom = sc.nextLine();
			if (nom.equals("q")) break;
			System.out.print("Entrez la note de "+ nom +" : ");
			String note = sc.nextLine();
			if (!mapNotes.containsKey(nom))
				mapNotes.put(nom, Integer.parseInt(note));
			else
				System.out.println("Eleve deja ajoute a la saisie !" + nom);

		}
		
		
		while (true) {
			System.out.println("\nChoix ?\n"
					+ "a. Afficher tous les notes\r\n"
					+ "b. Afficher la note pour l'utilsiateur specifique\r\n"
					+ "c. Afficher la quantite de note enregistree\r\n"
					+ "d. Afficher la moyenne des notes\r\n"
					+ "q. Quitter le programme\r\n");
			String response = sc.nextLine();
			if (response.equals("q")) {
				break;
			}

			else if (response.equals("a")) {
				System.out.println(mapNotes.values());
			}
				
			else if (response.equals("b")) {
				System.out.print("Eleve recherche ? ");
				String eleve = sc.nextLine();
				if (mapNotes.containsKey(eleve)) System.out.println(mapNotes.get(eleve));
				else System.out.println("L'eleve n'existe pas");

			} else if (response.equals("c")) {
				System.out.println("Vous avez saisi " + mapNotes.size() + " notes.");

			} else if (response.equals("d")) {
				int sum = 0;
				for (Entry<String, Integer> entry : mapNotes.entrySet()) {
					sum += entry.getValue();
				}
				System.out.println("La moyenne des notes est: " + (double) sum/mapNotes.size());
			}
		}
	}
}
