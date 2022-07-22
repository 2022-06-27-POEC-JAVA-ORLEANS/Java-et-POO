package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.Film;

public class FilmDaoImpl implements FilmDao {

	private static final String SQL_SELECT = "Select * From Film";
	private static final String SQL_SELECT_BY_ID = "Select * From Film Where id=?";
	private static final String SQL_INSERT = "Insert into Film(id_realisateur, titre, duree_minutes, genre) Values (?,?,?,?)";
	private static final String SQL_UPDATE = "Update Film Set id_realisateur=?, titre=?, duree_minutes=?, genre=? Where id=?";
	private static final String SQL_DELETE = "Delete From Film Where id=?";
	
	
	private DaoFactory factory;
	
	protected FilmDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<Film> list() throws DaoException {
		List<Film> listeFilms = new ArrayList<Film>();
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				listeFilms.add(map(rs));
			}
			
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Erreur de lecture Table Film");
		} finally {
			factory.releaseConnection(con);
		}
				
		
		return listeFilms;
	}

	@Override
	public Film read(long id) throws DaoException {
		Film r = new Film();
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_SELECT_BY_ID);
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				r = map(rs);
			} else {
				throw new DaoException("Le film avec l'id "+id+" n'existe pas.");
			}
			
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Erreur de lecture Table Film");
		} finally {
			factory.releaseConnection(con);
		}
		
		return r;
	}

	@Override
	public void create(Film film) throws DaoException {
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			
			if(film.getRealisateur() != null) {
				pst.setLong(1, film.getRealisateur().getId());
			} else {
				pst.setNull(1, Types.NULL);
				//throw new DaoException("Un realisateur ne peut pas être null.");
			}
			
			pst.setString(2, film.getTitre());
			pst.setInt(3, film.getDureeMinutes());
			pst.setString(4, film.getGenre());
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				ResultSet rsKeys = pst.getGeneratedKeys();
				if(rsKeys.next()) {
					film.setId(rsKeys.getLong(1));
				}
				rsKeys.close();
			} else {
				throw new DaoException("Impossible d'insérer le film : "+film.getTitre());
			}
			
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Impossible d'insérer le film : "+film.getTitre());
		} finally {
			factory.releaseConnection(con);
		}
	}

	@Override
	public void update(Film film) throws DaoException {
		Connection con = null;
		
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
			if(film.getRealisateur() != null) {
				pst.setLong(1, film.getRealisateur().getId());
			} else {
				pst.setNull(1, Types.NULL);
				//throw new DaoException("Un realisateur ne peut pas être null.");
			}
			pst.setString(2, film.getTitre());
			pst.setInt(3, film.getDureeMinutes());
			pst.setString(4, film.getGenre());
			pst.setLong(5, film.getId());
			
			int result = pst.executeUpdate();
			
			if(result != 1) {
				throw new DaoException("Impossible de mettre à jour le film : "+film.getTitre());
			}
			
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Impossible de mettre à jour le film : "+film.getTitre());
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
				throw new DaoException("Impossible de supprimer le film avec l'id : "+id);
			}
			
			pst.close();
			
		} catch (SQLException e) {
			throw new DaoException("Impossible de supprimer le film avec l'id : "+id);
		} finally {
			factory.releaseConnection(con);
		}
	}
	
	
	private static Film map(ResultSet rs) throws SQLException {
		Film f = new Film();
		f.setId(rs.getLong("id"));
		f.setTitre(rs.getString("titre"));
		f.setGenre(rs.getString("genre"));
		f.setDureeMinutes(rs.getInt("duree_minutes"));
		
		
		/*long idRealisateur = rs.getLong("id_realisateur");
		RealisateurDao realisateurDao = DaoFactory.getInstance().getRealisateurDao();
		try {
			Realisateur real = realisateurDao.read(idRealisateur);
			f.setRealisateur(real);
		} catch (DaoException e) {
			e.printStackTrace();
		}*/
		
		try {
			f.setRealisateur(DaoFactory.getInstance().getRealisateurDao().read(rs.getLong("id_realisateur")));
		} catch (DaoException e) {
			f.setRealisateur(null);
		}
		
		return f;
	}

}
