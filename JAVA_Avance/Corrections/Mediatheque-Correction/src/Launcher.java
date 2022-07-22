

import dao.DaoException;
import dao.DaoFactory;
import dao.RealisateurDao;
import model.Realisateur;

public class Launcher {
	public static void main(String[] args) {

		try {
			RealisateurDao realisateurDao = DaoFactory.getInstance().getRealisateurDao();
			
			System.out.println(realisateurDao.list());
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
			System.out.println(realisateurDao.read(13));
			
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}
}
