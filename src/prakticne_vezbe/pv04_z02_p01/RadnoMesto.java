package prakticne_vezbe.pv04_z02_p01;

public class RadnoMesto {

	
	private int ozrm;
	private String naziv;
	
	
	public RadnoMesto() {}
	
	
	public RadnoMesto(int ozrm, String naziv) {
		this.ozrm = ozrm;
		this.naziv = naziv;
	}


	public int ozrm() 		{ return ozrm; 	}
	public String naziv() 	{ return naziv; }


	public void setOzrm(int ozrm) 		{ this.ozrm = ozrm; 	}
	public void setNaziv(String naziv) 	{ this.naziv = naziv; 	}


	@Override
	public String toString() {
		return String.format("%5d %20s", ozrm(), naziv());
	}
}
