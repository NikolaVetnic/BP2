package prakticne_vezbe.pv04_z01_p01;

public class Predmet {

	
	private int idPredmeta;
	private String naziv;
	
	
	public Predmet() {}


	public Predmet(int idPredmeta, String naziv) {
		this.idPredmeta = idPredmeta;
		this.naziv = naziv;
	}


	public int idPredmeta() { return idPredmeta; 	}
	public String naziv() 	{ return naziv; 		}


	public void setIdPredmeta(int idPredmeta) 	{ this.idPredmeta = idPredmeta; }
	public void setNaziv(String naziv) 			{ this.naziv = naziv; 			}


	@Override
	public String toString() {
		return String.format("%5d %20s", idPredmeta(), naziv());
	}	
}
