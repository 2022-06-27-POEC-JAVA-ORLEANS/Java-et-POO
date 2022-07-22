import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Film;
import model.Realisateur;

public class LauncherFilm {

	public static void main(String[] args) {


		//Lister les films
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst = con.prepareStatement("Select * From Film");
			
			ResultSet rs = pst.executeQuery();
			
			List<Film> films = new ArrayList<Film>();
			while(rs.next()) {
				Film f = new Film();
				f.setId(rs.getLong("id"));
				f.setTitre(rs.getString("titre"));
				f.setDureeMinutes(rs.getInt("duree_minutes"));
				f.setGenre(rs.getString("genre"));

				long idRealisateur = rs.getLong("id_realisateur");
				PreparedStatement pst2 = con.prepareStatement("Select * From Realisateur Where id=?");
				pst2.setLong(1, idRealisateur);
				
				ResultSet rs2 = pst2.executeQuery();
				
				Realisateur r = new Realisateur();
				if(rs2.next()) {
					r.setId(rs2.getLong("id"));
					r.setNom(rs2.getString("nom"));
					r.setPrenom(rs2.getString("prenom"));
					r.setPays(rs2.getString("pays"));
					r.setAge(rs2.getInt("age"));
				}
				
				rs2.close();
				pst2.close();
				
				f.setRealisateur(r);
				
				films.add(f);
			}
			
			System.out.println(films);
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		//Récupérer un film par son id
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst = con.prepareStatement("Select * From Film Where id=?");
			pst.setLong(1, 2);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Film f = new Film();
				f.setId(rs.getLong("id"));
				f.setTitre(rs.getString("titre"));
				f.setDureeMinutes(rs.getInt("duree_minutes"));
				f.setGenre(rs.getString("genre"));
				
				long idRealisateur = rs.getLong("id_realisateur");
				PreparedStatement pst2 = con.prepareStatement("Select * From Realisateur Where id=?");
				pst2.setLong(1, idRealisateur);
				
				ResultSet rs2 = pst2.executeQuery();
				
				Realisateur r = new Realisateur();
				if(rs2.next()) {
					r.setId(rs2.getLong("id"));
					r.setNom(rs2.getString("nom"));
					r.setPrenom(rs2.getString("prenom"));
					r.setPays(rs2.getString("pays"));
					r.setAge(rs2.getInt("age"));
				}
				
				rs2.close();
				pst2.close();
				
				f.setRealisateur(r);
				
				System.out.println(f);
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		//Supprimer un film
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst = con.prepareStatement("Delete From Film Where id=?");
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
		
		
		//Ajouter un film
		Film film = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			PreparedStatement pst2 = con.prepareStatement("Select * From Realisateur Where id=?");
			pst2.setLong(1, 3);
			ResultSet rs2 = pst2.executeQuery();
			Realisateur r = new Realisateur();
			if(rs2.next()) {
				r.setId(rs2.getLong("id"));
				r.setNom(rs2.getString("nom"));
				r.setPrenom(rs2.getString("prenom"));
				r.setPays(rs2.getString("pays"));
				r.setAge(rs2.getInt("age"));
			}
			rs2.close();
			pst2.close();
			
			film = new Film(r, "La ligne verte", 150, "Tartampion");
			
			PreparedStatement pst = con.prepareStatement("Insert into Film(id_realisateur, titre, duree_minutes, genre) Values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setLong(1, film.getRealisateur().getId());
			pst.setString(2, film.getTitre());
			pst.setInt(3, film.getDureeMinutes());
			pst.setString(4, film.getGenre());
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				System.out.println("Création réussi");
			} else {
				System.out.println("Problème création");
			}
			
			ResultSet rsKeys = pst.getGeneratedKeys();
			if(rsKeys.next()) {
				film.setId(rsKeys.getLong(1));
			}
			
			System.out.println(film);
			
			rsKeys.close();
			pst.close();
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//Modifier un film
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mediatheque", "root", "");
			
			film.setTitre("Les évadées");
			
			PreparedStatement pst = con.prepareStatement("Update Film Set id_realisateur=?, titre=?, duree_minutes=?, genre=? Where id=?");
			pst.setLong(1, film.getRealisateur().getId());
			pst.setString(2, film.getTitre());
			pst.setInt(3, film.getDureeMinutes());
			pst.setString(4, film.getGenre());
			pst.setLong(5, film.getId());
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				System.out.println("Modification réussi");
			} else {
				System.out.println("Problème Modification");
			}
			
			System.out.println(film);
			
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	

	}

}
