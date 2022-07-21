import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import tp13.Categorie;
import tp13.CategorieException;
import tp13.User;

public class tp14 {
	
	static HashMap<User, Boolean> usersActifs = new HashMap<User, Boolean>();

	public static void main(String args[]) throws CategorieException {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nom ? (ou quitter):");
			String result1 = sc.nextLine();
			if (result1.equals("q")) break;
			System.out.print("Prenom ? :");
			String result2 = sc.nextLine();
			System.out.print("Age ? :");
			int age = Integer.parseInt(sc.nextLine());
			User inscrit = new User(result1, result2, age);

			try {		
				System.out.print("Categorie ?\n a.ENFANT\n b.IS_15_TO_17\n c.SENIOR:");
				String cat = sc.nextLine();
				Categorie catReel = Categorie.UNDEFINED;
				switch(cat) {
					case "a": catReel = Categorie.ENFANT; break;
					case "b": catReel = Categorie.IS_15_TO_17; break;
					case "c": catReel = Categorie.SENIOR; break;
				}
				checkCategorie(age, catReel);
				inscrit.setCategorie(catReel);
				usersActifs.put(inscrit, true);
			} catch (CategorieException e) {
				System.out.print(e);
				usersActifs.put(inscrit, false);
			}
		}
		
		
		for (Entry<User, Boolean> e: usersActifs.entrySet()) {
			if (e.getValue()) {
				System.out.println(e.getKey().getNom());
			}
		}
		
		

	}

	public static void checkCategorie(int age, Categorie categorie) throws CategorieException {
		if (age < 18 && categorie.equals(Categorie.SENIOR)
				|| age < 15 && !categorie.equals(Categorie.ENFANT)
				|| age >= 15 && categorie.equals(Categorie.ENFANT)
				|| categorie.equals(Categorie.UNDEFINED))
			throw new CategorieException(categorie.toString());

	}

}
