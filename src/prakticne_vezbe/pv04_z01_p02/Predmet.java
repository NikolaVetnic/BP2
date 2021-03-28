package prakticne_vezbe.pv04_z01_p02;

public class Predmet {

	
	private int idPredmeta;
	private String naziv;
	
	
	public Predmet() {}
	
	
	public Predmet(int idNastavnika, String naziv) {
		this.idPredmeta = idNastavnika;
		this.naziv = naziv;
	}


	public int idPredmeta() { return idPredmeta; }
	public String naziv() { return naziv; }


	public void setIdPredmeta(int idPredmeta) { this.idPredmeta = idPredmeta; }
	public void setNaziv(String naziv) { this.naziv = naziv; }
	
	
	@Override
	public String toString() {
		return String.format("%5d %20s", idPredmeta(), naziv());
	}
}
