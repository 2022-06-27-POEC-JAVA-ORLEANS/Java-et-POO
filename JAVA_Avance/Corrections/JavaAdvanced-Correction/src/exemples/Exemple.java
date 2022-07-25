package exemples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Exemple {

	public static void main(String[] args) {

		List<String> couleurs = new ArrayList<String>();
		couleurs.add("Bleu");
		couleurs.add("Blanc");
		couleurs.add("Rouge");
		
		for(int i = 0; i < couleurs.size(); i++) {
			System.out.println(couleurs.get(i));
		}
		
		System.out.println("--------------");
		
		for(String couleur : couleurs) {
			System.out.println(couleur);
		}
		
		System.out.println("--------------");
		
		Iterator<String> it = couleurs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Map<String, Integer> notes = new HashMap<String, Integer>();
		notes.put("Duncan", 16);
		notes.put("Maryline", 17);
		notes.put("Imen", 18);
		
		//notes.keySet().iterator()
		
		System.out.println(notes.get("Imen"));
		for(Integer i : notes.values()) {
			System.out.println(i);
		}
		
	}

}
