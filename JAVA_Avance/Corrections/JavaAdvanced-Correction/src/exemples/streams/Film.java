package exemples.streams;

public class Film {

	private Long id;
	private Realisateur realisateur;
	private String titre;
	private int dureeMinutes;
	private String genre;
	
	public Film() {
		
	}
	
	public Film(Realisateur realisateur, String titre, int dureeMinutes, String genre) {
		this.realisateur = realisateur;
		this.titre = titre;
		this.dureeMinutes = dureeMinutes;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDureeMinutes() {
		return dureeMinutes;
	}

	public void setDureeMinutes(int dureeMinutes) {
		this.dureeMinutes = dureeMinutes;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return getId() + " : " + getTitre() + " de " + getRealisateur().getPrenom() + " " + getRealisateur().getNom() + " / " + getDureeMinutes() + " minutes / Genre : " + getGenre();
	}
	
	
}
