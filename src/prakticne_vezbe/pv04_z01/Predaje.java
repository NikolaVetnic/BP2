package prakticne_vezbe.pv04_z01;

public class Predaje {

	
	private int idNastavnika, idPredmeta;
	
	
	public Predaje() {}


	public Predaje(int idNastavnika, int idPredmeta) {
		super();
		this.idNastavnika = idNastavnika;
		this.idPredmeta = idPredmeta;
	}


	public int getIdNastavnika() {
		return idNastavnika;
	}


	public void setIdNastavnika(int idNastavnika) {
		this.idNastavnika = idNastavnika;
	}


	public int getIdPredmeta() {
		return idPredmeta;
	}


	public void setIdPredmeta(int idPredmeta) {
		this.idPredmeta = idPredmeta;
	}


	@Override
	public String toString() {
		return "Predaje [idNastavnika=" + idNastavnika + ", idPredmeta=" + idPredmeta + "]";
	}
	
	
	
}
