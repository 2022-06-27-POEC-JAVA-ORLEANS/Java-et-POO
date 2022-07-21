package dao;

import java.util.List;

import model.Realisateur;

public interface RealisateurDao {
	
	List<Realisateur> list() throws DaoException;
	
	Realisateur read(long id) throws DaoException;
	
	void create(Realisateur realisateur) throws DaoException;
	
	void update(Realisateur realisateur) throws DaoException;
	
	void delete(long id) throws DaoException;
}
