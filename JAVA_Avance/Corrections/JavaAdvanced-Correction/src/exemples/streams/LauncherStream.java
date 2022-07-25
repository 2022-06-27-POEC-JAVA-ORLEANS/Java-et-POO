package exemples.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LauncherStream {

	public static void main(String[] args) {
		
		//Création de la liste
		List<Realisateur> realisateurList = new ArrayList<>();
		
		realisateurList.add(new Realisateur("Eastwood", "Clint", 92, "Etats-Unis"));
		realisateurList.add(new Realisateur("Spielberg'", "Steven", 75, "Etats-Unis"));
		realisateurList.add(new Realisateur("Von Trier", "Lars", 66, "Danemark"));
		realisateurList.add(new Realisateur("Achour", "Mouloud", 41, "France"));

		
		
		//Récupération de la liste triée sans l’utilisation des streams
		List<Realisateur> eURealisateurList = new ArrayList<>();

		for (Realisateur r : realisateurList) {
			if (r.getPays().equals("Etats-Unis")) {
				eURealisateurList.add(r);
			}
		}

		
		Collections.sort(eURealisateurList, (o1, o2) -> o1.getNom().compareTo(o2.getNom()));

		List<String> results1 = new ArrayList<>();

		for (Realisateur r : eURealisateurList) {
			results1.add(r.getNom());
		}
		
		System.out.println(results1);
		
		System.out.println("------------");
		
		
		//Récupération de la liste triée avec l’utilisation de Stream
		List<String> results2 =  realisateurList.stream()
				.filter(r-> r.getPays().equals("Etats-Unis"))
				.sorted(Comparator.comparing(Realisateur::getNom))
				.map(Realisateur::getNom)
				.collect(Collectors.toList());
		
		System.out.println(results2);
		
	}
}
