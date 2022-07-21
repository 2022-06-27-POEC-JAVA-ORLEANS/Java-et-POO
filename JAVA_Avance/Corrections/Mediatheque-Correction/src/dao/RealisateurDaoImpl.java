package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Realisateur;

public class RealisateurDaoImpl implements RealisateurDao {

	private static final String SQL_SELECT = "Select * From Realisateur";
	
	
	private DaoFactory factory;
	
	public RealisateurDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<Realisateur> list() throws DaoException {
		List<Realisateur> listeRealisateurs = new ArrayList<Realisateur>();
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				listeRealisateurs.add(map(rs));
			}
			
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Erreur de lecture Table Realisateur");
		} finally {
			factory.releaseConnection(con);
		}
				
		
		return listeRealisateurs;
	}

	@Override
	public Realisateur read(long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Realisateur realisateur) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Realisateur realisateur) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	
	
	private static Realisateur map(ResultSet rs) throws SQLException {
		Realisateur r = new Realisateur();
		r.setId(rs.getLong("id"));
		r.setNom(rs.getString("nom"));
		r.setPrenom(rs.getString("prenom"));
		r.setPays(rs.getString("pays"));
		r.setAge(rs.getInt("age"));
		
		return r;
	}

}
