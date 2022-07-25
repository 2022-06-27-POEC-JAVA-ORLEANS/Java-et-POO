package exemples.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class AsynchroneCompteur{
	
	// Variables
	String nom;
	int maximum;
  
	// Constructeurs
	public AsynchroneCompteur(String nom, int maximum) {
		this.nom = nom;
		this.maximum = maximum;
	}

	public AsynchroneCompteur(String nom) {
		this(nom, 3);
	}
  
	public CompletableFuture<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();
	
	    Executors.newCachedThreadPool().submit(() -> {
	    	String result = "";
    		for (int i = 1; i <= maximum; i++) {
    	      try {
    		      Thread.sleep((int)(Math.random() * 3000));
    	      } catch(InterruptedException e) {
    	    	  result += "\n" + nom + " a ete interrompu.";
    	      }
    	      result += "\n" + nom + " : " + i;
    	    }
    		result += "\n*** " + nom + " a fini de compter jusqu'à " + maximum;
    		System.out.println(result);
    		completableFuture.complete(result);
	        return null;
	    });
	
	    return completableFuture;
	}

	public static void main(String[] args) {
		try {
			CompletableFuture<String> future1 = new AsynchroneCompteur("Julius").calculateAsync();
			CompletableFuture<String> future2 = new AsynchroneCompteur("Toto").calculateAsync();
			CompletableFuture<String> future3 = new AsynchroneCompteur("Luffy").calculateAsync();
			
			CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
			combinedFuture.get();
			
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
  
}