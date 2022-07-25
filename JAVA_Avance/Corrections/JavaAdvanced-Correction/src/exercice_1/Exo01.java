package exercice_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Exo01 {
	  public static void main(String args[]) {

	    Scanner sc = new Scanner(System.in);
	    List<Integer> list = new ArrayList<Integer>();
	    
	    boolean isReady = true;	    
	    
	    do {
	      System.out.print("Entrez un nombre :");
	      String response = sc.nextLine(); 
	      if (response.equals("q")) {
	    	  isReady = false;
	      } else {
	    	  try {
		        int newNumber = Integer.parseInt(response);
		        if (!list.contains(newNumber)){ 
		          list.add(newNumber);
		        } else {
		          Integer positionDoublon = list.indexOf(newNumber)+1;
		          System.out.println("Chiffre déja ajouté à la saisie !" + positionDoublon);
		        }
	    	  } catch(NumberFormatException e) {
	    		  System.out.println("Vous devez entrer un nombre ou 'q' pour quitter !");
	    	  }
	      }
	    
	    } while(isReady);
	    sc.close();
	    
	    for(Integer e : list) {
	      System.out.print(e + ", ");
	    }

	    System.out.println("\n----------------------\n");
	    
	    Iterator<Integer> i = list.iterator();
	    while (i.hasNext()) {
	      System.out.print(i.next() + ", ");
	    }
	    
	    System.out.println("\n----------------------\n");

	    System.out.println("Vous avez saisi " + list.size() + " nombres.");
	}
}
