

import dao.DaoException;
import dao.DaoFactory;
import dao.RealisateurDao;

public class Launcher {
	public static void main(String[] args) {

		try {
			RealisateurDao realisateurDao = DaoFactory.getInstance().getRealisateurDao();
			
			System.out.println(realisateurDao.list());
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
