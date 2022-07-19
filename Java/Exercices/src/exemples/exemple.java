package exemples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class exemple {

	public static void main(String[] args) throws ExempleException {

		// Exemple 1 - Les bases
		/*System.out.println("Lancement du programme !");
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir un mot");
		String motSaisi = sc.nextLine();
		System.out.println(motSaisi);
		System.out.println("Saisir un mot 2");
		String motSaisi2 = sc.nextLine();
		System.out.println(motSaisi2);*/



		// Exemple 2 - Les classes
		/*Ecole ecole1 = new Ecole();
		Ecole ecole2 = new Ecole("Ecole 1");
		Ecole ecole3 = new Ecole("Ecole 1", "option1", 10);

		System.out.println(ecole2.getNom());
		System.out.println(ecole2.getNbClasses());
		ecole2.setNbClasses(19);
		System.out.println(ecole2.getNbClasses());
		ecole2.ajouter(3);
		System.out.println(ecole2.getNbClasses());

		System.out.println(ecole3);*/



		// Exemple 3 - Heritage, interfaces et Annnotations
		/*Humain pierre = new Humain();
		System.out.println(pierre.getCategorie());
		System.out.println(pierre.afficherDUreeVie());

		EtreVivant ahmed = new Humain();*/




		// Exemple 4 - Exceptions
		try {
			Ecole ecole1 = new Ecole("B");
			Ecole ecole2 = new Ecole("A");
			checkValidityEcole(ecole1);
			checkValidityEcole(ecole2);
		} catch (ExempleException e) {
			System.out.println(e);
		}
	}
	
	
	
	

	public static void checkValidityEcole(Ecole ecole) throws ExempleException {
		if (ecole.getNom().equals("A")) {
			throw new ExempleException("Problème sur le nom de l'Ecole " + ecole);
		}
	}
}
