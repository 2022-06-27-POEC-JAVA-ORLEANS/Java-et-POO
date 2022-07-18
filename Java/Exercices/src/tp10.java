import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class tp10 {
	
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();

		while (true) {
			System.out.print("Entrez un nombre ou quitter avec q:");
			String response = sc.nextLine();
			if (response.equals("q")) {
				break;
			}
			else {
				int newNumber = Integer.parseInt(response);
				if (!list.contains(newNumber)) {
					list.add(newNumber);
				} else {
					int positionDoublon = list.indexOf(newNumber)+1;
					System.out.println("Chiffre deja ajoute a la position " + positionDoublon);
				}
			}
		}

		while (true) {
			System.out.println("\nChoix ?\n"
					+ "a. Afficher tous les nombres\r\n"
					+ "b. Afficher un nombre a une position specifique (Gestion si la position nexiste pas)\r\n"
					+ "c. Afficher la quantite de nombre enregistree\r\n"
					+ "d. Afficher la moyenne des nombres\r\n"
					+ "q. Quitter le programme\r\n");
			String response = sc.nextLine();
			if (response.equals("q")) break;

			else if (response.equals("a")) {
				Iterator<Integer> i = list.iterator();
				while (i.hasNext()) {
					System.out.println(i.next());
				}

			} else if (response.equals("b")) {
				System.out.println("Position souhaitee ? ");
				int pos = sc.nextInt();
				if (list.size()-1 < pos) {
					System.out.print("Desole, Aucun nombre a cette position");
				} else {
					System.out.println("Le nombre est: " + list.get(pos));
				}

			} else if (response.equals("c")) {
				System.out.println("Vous avez saisi " + list.size() + " nombres.");

			} else if (response.equals("d")) {
				Iterator<Integer> i = list.iterator();
				int sum = 0;
				while (i.hasNext()) {
					sum += (int) i.next();
				}
				//double mouyenne = sum/list.size();
				System.out.println("La moyenne des nombres est: " + (double) sum/list.size());
			}
		}
		
		
	}

}
