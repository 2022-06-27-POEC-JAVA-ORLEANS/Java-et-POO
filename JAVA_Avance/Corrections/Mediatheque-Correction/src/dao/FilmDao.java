package dao;

import java.util.List;

import model.Film;

public interface FilmDao {
	
	List<Film> list() throws DaoException;
	
	Film read(long id) throws DaoException;
	
	void create(Film film) throws DaoException;
	
	void update(Film film) throws DaoException;
	
	void delete(long id) throws DaoException;
}
