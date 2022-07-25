package exercice_2;

import java.util.ArrayList;
import java.util.List;

public class Exo02 {
	public static void main(String[] args) 
	{
		Voiture voiture = new Voiture("Porshe");
		Bateau bateau = new Bateau();
		
		voiture.displayActions();
		bateau.displayActions();
		
		List<ActionVehicule> listVehicule = new ArrayList<ActionVehicule>();
		listVehicule.add(voiture);
		listVehicule.add(bateau);
		
		for(ActionVehicule v : listVehicule) {
			System.out.println(v);
			if(v instanceof Voiture) {
				System.out.println("Ceci est une voiture.");
			}
			if(v instanceof Bateau) {
				System.out.println("Ceci est un bateau.");
			}
		}
		
		System.out.println("\n----------------------\n");
		
		ActionVehicule avion = new ActionVehicule() {
			@Override
			public boolean peutVoler() {return true;}	

			@Override
			public boolean peutRouler() {return false;}
			
			@Override
			public boolean peutNaviguer() {return false;}

			@Override
			public void displayActions() {
				System.out.println("L'Avion peut : Voler ? " + this.peutVoler() + ", Rouler ? " + this.peutRouler() + ", Naviguer ? " + this.peutNaviguer());
			}
		};
		
		avion.displayActions();
		
		listVehicule.add(avion);
		
		for(ActionVehicule v : listVehicule) {
			System.out.println(v);
			if(v instanceof Voiture) {
				System.out.println("Ceci est une voiture.");
			} else if(v instanceof Bateau) {
				System.out.println("Ceci est un bateau.");
			} else {
				System.out.println("Ceci est un avion.");
			}
		}
		
	}
}
