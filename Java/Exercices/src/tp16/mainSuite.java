package tp16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class mainSuite {

	static List<Sport> listSport = new ArrayList<Sport>();

	public static void main(String[] args) {
		getDatas();
		for (Sport s: listSport) {
			s.afficher();
		}
	}
	
	
	
	public static void getDatas() {
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
	
	
	

}
