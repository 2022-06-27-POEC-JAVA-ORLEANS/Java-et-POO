package tp16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {
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
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
				System.out.println(res.getBoolean(4));
				System.out.println(res.getString(5));
			}

			// Close
			conn.close();
		}
		catch(Exception e){ 
			System.out.println(e);
		}
	}

}
