package prakticne_vezbe.pv04_z01;

public class Predmet {

	
	private int idPredmeta;
	private String naziv;
	
	
	public Predmet() {}


	public Predmet(int idPredmeta, String naziv) {
		this.idPredmeta = idPredmeta;
		this.naziv = naziv;
	}


	public int getIdPredmeta() {
		return idPredmeta;
	}


	public void setIdPredmeta(int idPredmeta) {
		this.idPredmeta = idPredmeta;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	@Override
	public String toString() {
		return "Predmet [idPredmeta=" + idPredmeta + ", naziv=" + naziv + "]";
	}
	
	
	
}
