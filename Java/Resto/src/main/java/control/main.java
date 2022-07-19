package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Restaurant;
import model.Salarie;

public class main {

	static List<Restaurant> listRestau = new ArrayList<Restaurant>();
	static List<Salarie> listSalarie = new ArrayList<Salarie>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("Start App Restaurant ");
		addRestau();
		addSalarie();
		addSalarie();
		getRestaurants();
	}


	public static void addRestau() {
		Restaurant r = new Restaurant();
		System.out.print("Code restaurant ?");
		r.setCode(sc.nextLine());
		System.out.print("Nom restaurant ?");
		r.setNom(sc.nextLine());
		System.out.print("Adresse restaurant ?");
		r.setAdresse(sc.nextLine());
		System.out.print("Tables restaurant ?");
		r.setNbTables(Integer.parseInt(sc.nextLine()));
		System.out.print("Statut (o/f) restaurant ?");
		switch(sc.nextLine()) {
			case "o": r.setStatut(true); break;
			case "f": r.setStatut(false); break;
			default : r.setStatut(false); break;
		}
		main.listRestau.add(r);
	}

	public static void addSalarie() {
		Salarie s = new Salarie();
		System.out.print("Nom ?");
		s.setNom(sc.nextLine());
		System.out.print("Prenom ?");
		s.setPrenom(sc.nextLine());
		System.out.print("Salaire ?");
		s.setSalaire(Double.parseDouble(sc.nextLine()));
		System.out.print("Code Restau ?");
		s.setCodeResto(sc.nextLine());
		main.listSalarie.add(s);

		for (Restaurant resto : main.listRestau) {
			if (resto.getCode().equals(s.getCodeResto())) {
				resto.addSalarie(s);
				break;
			}	
		}
	}
	
	public static void getRestaurants() {
		for (Restaurant resto : main.listRestau)
			System.out.println(resto.toString());
	}

}
