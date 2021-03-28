package prakticne_vezbe.pv04_z01_p02;

public class Predaje {

	
	private int idNastavnika;
	private int idPredmeta;
	
	
	public Predaje() {}
	
	
	public Predaje(int idNastavnika, int idPredmeta) {
		this.idNastavnika = idNastavnika;
		this.idPredmeta = idPredmeta;
	}


	public int idNastavnika() 	{ return idNastavnika; 	}
	public int idPredmeta() 	{ return idPredmeta; 	}


	public void setIdNastavnika(int idNastavnika) 	{ this.idNastavnika = idNastavnika; }
	public void setIdPredmeta(int idPredmeta) 		{ this.idPredmeta = idPredmeta; 	}
	
	
	@Override
	public String toString() {
		return String.format("%5d %5d", idNastavnika(), idPredmeta());
	}
}
