

import dao.DaoException;
import dao.DaoFactory;
import dao.FilmDao;
import dao.RealisateurDao;
import model.Film;
import model.Realisateur;

public class Launcher {
	public static void main(String[] args) {

		try {
			RealisateurDao realisateurDao = DaoFactory.getInstance().getRealisateurDao();
			
			/*System.out.println(realisateurDao.list());
			System.out.println(realisateurDao.read(2));
			//System.out.println(realisateurDao.read(0));
			
			System.out.println("-----------------");
			
			Realisateur realisateur = new Realisateur("Cases", "Alexandre", 27, "France");
			System.out.println(realisateur);
			realisateurDao.create(realisateur);
			System.out.println(realisateur);
			
			System.out.println("-----------------");
			
			realisateur.setPrenom("Alex");
			realisateurDao.update(realisateur);
			System.out.println(realisateur);
			
			System.out.println("-----------------");
			System.out.println(realisateurDao.read(13));
			realisateurDao.delete(13);
			System.out.println(realisateurDao.read(13));*/
			
			FilmDao filmDao = DaoFactory.getInstance().getFilmDao();
			System.out.println(filmDao.list());
			System.out.println(filmDao.read(8));
			System.out.println(filmDao.read(2));
			
			System.out.println("-----------------");
			
			Film film1 = new Film(realisateurDao.read(2), "La ligne verte", 150, "Tartampion");
			Film film2 = new Film(null, "La ligne verte 2", 150, "Tartampion 2");
			System.out.println(film1);
			System.out.println(film2);
			
			filmDao.create(film1);
			System.out.println(film1);
			
			filmDao.create(film2);
			System.out.println(film2);
			
			
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}
}
