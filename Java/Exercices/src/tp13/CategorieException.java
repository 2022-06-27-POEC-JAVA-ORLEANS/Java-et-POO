package tp13;

public class CategorieException extends Exception {
	public CategorieException(String cat) {
		super("Erreur de categorie, votre age ne permet pas la categorie " + cat + "\n");
	}
}
