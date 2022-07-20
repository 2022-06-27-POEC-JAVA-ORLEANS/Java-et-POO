package exemples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tp06.Type;

public class exemple {

	public static void main(String[] args) throws ExempleException, SQLException {

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
		/*try {
			Ecole ecole1 = new Ecole("B");
			Ecole ecole2 = new Ecole("A");
			checkValidityEcole(ecole1);
			checkValidityEcole(ecole2);
		} catch (ExempleException e) {
			System.out.println(e);
		}*/
		
		
		
		// Exemple 5 - JDBC POSTGRES

		// 1. Charge le Driver + 2. Connexion (url + ids)
		/*try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/site_internet", "usersite", "usersite");
			
			// 3. Request + 4.Execution
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM page");
			
			// 5. Lire r�sultats
			while(res.next()) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
			}
			
			// 6. Fermer connexion
			conn.close();
			
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		*/
		
		
		
		// Exemple 5.2 - JDBC POSTGRES - INSERT

		// 1. Charge le Driver + 2. Connexion (url + ids)
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/site_internet", "usersite", "usersite");
			
			// Preparer request
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO site VALUES (?, ?)");
			
			// Insertion des donn�es pour la requ�te
            preparedStatement.setString(1, "http://mysite3.fr");
            preparedStatement.setString(2, "EN");
            System.out.println(preparedStatement);
            
            // Execution de la requ�te
            preparedStatement.executeUpdate();
			
			// 6. Fermer connexion
			conn.close();
			
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}




	public static void checkValidityEcole(Ecole ecole) throws ExempleException {
		if (ecole.getNom().equals("A")) {
			throw new ExempleException("Probl�me sur le nom de l'Ecole " + ecole);
		}
	}
}
