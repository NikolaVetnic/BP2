package prakticne_vezbe.pv04_z02_p02;

public class Radnik {

	
	private int mbr;
	private String ime, prz, datr;
	private int ozrm;
	
	
	public Radnik() {}
	
	
	public Radnik(int mbr, String ime, String prz, String datr, int ozrm) {
		this.mbr = mbr;
		this.ime = ime;
		this.prz = prz;
		this.datr = datr;
		this.ozrm = ozrm;
	}


	public int mbr() 		{ return mbr; 	}
	public String ime() 	{ return ime; 	}
	public String prz() 	{ return prz; 	}
	public String datr() 	{ return datr; 	}
	public int ozrm() 		{ return ozrm; 	}


	public void setMbr(int mbr) 		{ this.mbr = mbr; 	}
	public void setIme(String ime) 		{ this.ime = ime; 	}
	public void setPrz(String prz) 		{ this.prz = prz; 	}
	public void setDatr(String datr) 	{ this.datr = datr; }
	public void setOzrm(int ozrm) 		{ this.ozrm = ozrm; }

	
	@Override
	public String toString() {
		return String.format("%5d %20s %20s %10s %5d", mbr(), ime(), prz(), datr(), ozrm());
	}
}
