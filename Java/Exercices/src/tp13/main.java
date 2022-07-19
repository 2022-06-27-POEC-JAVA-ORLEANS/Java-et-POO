package tp13;

import java.util.Scanner;

public class main {

	public static void main(String args[]) throws CategorieException {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nom ? :");
			String result1 = sc.nextLine();
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
					default : catReel = Categorie.UNDEFINED; break;
				}
				checkCategorie(age, catReel);
				inscrit.setCategorie(catReel);	
			} catch (CategorieException e) {
				System.out.print(e);
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
