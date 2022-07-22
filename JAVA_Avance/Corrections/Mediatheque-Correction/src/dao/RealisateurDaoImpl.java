package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Realisateur;

public class RealisateurDaoImpl implements RealisateurDao {

	private static final String SQL_SELECT = "Select * From Realisateur";
	private static final String SQL_SELECT_BY_ID = "Select * From Realisateur Where id=?";
	private static final String SQL_INSERT = "Insert into Realisateur(nom, prenom, age, pays) Values (?,?,?,?)";
	private static final String SQL_UPDATE = "Update Realisateur Set nom=?, prenom=?, age=?, pays=? Where id=?";
	private static final String SQL_DELETE = "Delete From Realisateur Where id=?";
	
	
	private DaoFactory factory;
	
	protected RealisateurDaoImpl(DaoFactory factory) {
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
		Realisateur r = new Realisateur();
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_SELECT_BY_ID);
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				r = map(rs);
			} else {
				throw new DaoException("Le realisateur avec l'id "+id+" n'existe pas.");
			}
			
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Erreur de lecture Table Realisateur");
		} finally {
			factory.releaseConnection(con);
		}
		
		return r;
	}

	@Override
	public void create(Realisateur realisateur) throws DaoException {
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, realisateur.getNom());
			pst.setString(2, realisateur.getPrenom());
			pst.setInt(3, realisateur.getAge());
			pst.setString(4, realisateur.getPays());
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				ResultSet rsKeys = pst.getGeneratedKeys();
				if(rsKeys.next()) {
					realisateur.setId(rsKeys.getLong(1));
				}
				rsKeys.close();
			} else {
				throw new DaoException("Impossible d'insérer le réalisateur : "+realisateur.getNom());
			}
			
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Impossible d'insérer le réalisateur : "+realisateur.getNom());
		} finally {
			factory.releaseConnection(con);
		}
	}

	@Override
	public void update(Realisateur realisateur) throws DaoException {
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
			pst.setString(1, realisateur.getNom());
			pst.setString(2, realisateur.getPrenom());
			pst.setInt(3, realisateur.getAge());
			pst.setString(4, realisateur.getPays());
			pst.setLong(5, realisateur.getId());
			
			int result = pst.executeUpdate();
			
			if(result != 1) {
				throw new DaoException("Impossible de mettre à jour le réalisateur : "+realisateur.getNom());
			}
			
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Impossible de mettre à jour le réalisateur : "+realisateur.getNom());
		} finally {
			factory.releaseConnection(con);
		}
	}

	@Override
	public void delete(long id) throws DaoException {
		Connection con = null;
				
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_DELETE);
			pst.setLong(1, id);
			
			int result = pst.executeUpdate();
			
			if(result != 1) {
				throw new DaoException("Impossible de supprimer le réalisateur avec l'id : "+id);
			}
			
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Impossible de supprimer le réalisateur avec l'id : "+id);
		} finally {
			factory.releaseConnection(con);
		}
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
