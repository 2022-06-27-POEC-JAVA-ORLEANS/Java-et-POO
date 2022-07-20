package tp16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class mainSuite2 {

	static List<Sport> listSport = new ArrayList<Sport>();

	public static void main(String[] args) {
		// Tests méthodes
		
		/*Sport sport = new Sport("Hockey", Type.EQUIPE, true, "Sport de glace...");
		addSport(sport);
		getSports();
		for (Sport s: listSport) {
			s.afficher();
		}*/

		
		// Programme Complet
		afficherChoixUser();
	}



	public static void getSports() {
		try {
			// Load driver
			Class.forName("org.postgresql.Driver");

			// Connection
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/sport","usport","usport");

			// Add Statement and execute request
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM sport");

			// Read request
			while(res.next()) {
				Sport sport = new Sport();
				sport.setId(res.getInt(1));
				sport.setNom(res.getString(2));
				sport.setActif(res.getBoolean(4));
				sport.setDescription(res.getString(5));
				switch (res.getString(3)) {
				case "INDIVIDUEL": sport.setType(Type.INDIVIDUEL); break;
				case "EQUIPE": sport.setType(Type.EQUIPE); break;
				case "INDIVIDUEL_ET_EQUIPE": sport.setType(Type.INDIVIDUEL_ET_EQUIPE); break;
				}
				listSport.add(sport);
			}

			// Close
			conn.close();
		}
		catch(Exception e){ 
			System.out.println(e);
		}
	}

	public static void addSport(Sport sport) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/sport","usport","usport");
			
			// Preparer request
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO sport (nom, type, actif, description) VALUES (?, ?, ?, ?)");

			// Insertion des donnï¿½es pour la requï¿½te
			preparedStatement.setString(1, sport.getNom());
			preparedStatement.setString(2, sport.getType().toString());
			preparedStatement.setBoolean(3, sport.isActif());
			preparedStatement.setString(4, sport.getDescription());
		
			// Execution de la requï¿½te
			preparedStatement.executeUpdate();

			// 6. Fermer connexion
			conn.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void afficherChoixUser() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\nChoix ?\n"
					+ "a. Lister les sports\r\n"
					+ "b. Ajouter un sport\r\n"
					+ "q. Quitter le programme\r\n");
			String response = sc.nextLine();
			
			// QUITTER
			if (response.equals("q")) break;
			
			// LIRE TOUS LES SPORTS
			else if (response.equals("a")) {
				getSports();
				for (Sport s: listSport) {
					s.afficher();
				}
			}
			
			// AJOUTER UN SPORT
			else if (response.equals("b")) {
				Sport newSport = new Sport();
				System.out.println("Nom du sport à ajouter ? ");
				newSport.setNom(sc.nextLine());
				System.out.println("Description du sport à ajouter ? ");
				newSport.setDescription(sc.nextLine());
				System.out.println("Actif (y/n) ?");
				if (sc.nextLine().equals("y"))
					newSport.setActif(true);
				else newSport.setActif(false);
				System.out.println("Type (indiv/equip/both) ?");
				if (sc.nextLine().equals("indiv"))
					newSport.setType(Type.INDIVIDUEL);
				else if  (sc.nextLine().equals("equip"))
					newSport.setType(Type.EQUIPE);
				else
					newSport.setType(Type.INDIVIDUEL_ET_EQUIPE);
				addSport(newSport);
			}
		}

	}

}
