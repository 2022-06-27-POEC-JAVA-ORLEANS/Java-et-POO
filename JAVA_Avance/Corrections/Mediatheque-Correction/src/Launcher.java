import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Realisateur;

public class Launcher {

	public static void main(String[] args) {

		//Lister les réalisateurs
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst = con.prepareStatement("Select * From Realisateur");
			
			ResultSet rs = pst.executeQuery();
			
			List<Realisateur> realisateurs = new ArrayList<Realisateur>();
			while(rs.next()) {
				Realisateur r = new Realisateur();
				r.setId(rs.getLong("id"));
				r.setNom(rs.getString("nom"));
				r.setPrenom(rs.getString("prenom"));
				r.setPays(rs.getString("pays"));
				r.setAge(rs.getInt("age"));
				
				realisateurs.add(r);
			}
			
			System.out.println(realisateurs);
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		//Récupérer un réalisateur par son id
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst = con.prepareStatement("Select * From Realisateur Where id=?");
			pst.setLong(1, 2);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Realisateur r = new Realisateur();
				r.setId(rs.getLong("id"));
				r.setNom(rs.getString("nom"));
				r.setPrenom(rs.getString("prenom"));
				r.setPays(rs.getString("pays"));
				r.setAge(rs.getInt("age"));
				
				System.out.println(r);
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		//Supprimer un réalisateur
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst = con.prepareStatement("Delete From Realisateur Where id=?");
			pst.setLong(1, 1);
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				System.out.println("Suppression réussi");
			} else {
				System.out.println("Problème suppression");
			}
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		
		//Ajouter un réalisateur
		Realisateur realisateur = new Realisateur("Cases", "Alexandre", 27, "France");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst = con.prepareStatement("Insert into Realisateur(nom, prenom, age, pays) Values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, realisateur.getNom());
			pst.setString(2, realisateur.getPrenom());
			pst.setInt(3, realisateur.getAge());
			pst.setString(4, realisateur.getPays());
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				System.out.println("Création réussi");
			} else {
				System.out.println("Problème création");
			}
			
			ResultSet rsKeys = pst.getGeneratedKeys();
			if(rsKeys.next()) {
				realisateur.setId(rsKeys.getLong(1));
			}
			
			System.out.println(realisateur);
			
			rsKeys.close();
			pst.close();
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		//Modifier un réalisateur
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			realisateur.setPrenom("Alex");
			
			PreparedStatement pst = con.prepareStatement("Update Realisateur Set nom=?, prenom=?, age=?, pays=? Where id=?");
			pst.setString(1, realisateur.getNom());
			pst.setString(2, realisateur.getPrenom());
			pst.setInt(3, realisateur.getAge());
			pst.setString(4, realisateur.getPays());
			pst.setLong(5, realisateur.getId());
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				System.out.println("Modification réussi");
			} else {
				System.out.println("Problème Modification");
			}
			
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	

	}

}
