package prakticne_vezbe.pv04_z01_p02;

public class Nastavnik {

	
	private int idNastavnika;
	private String ime, prezime, zvanje;
	
	
	public Nastavnik() {}
	
	
	public Nastavnik(int idNastavnika, String ime, String prezime, String zvanje) {
		this.idNastavnika = idNastavnika;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
	}


	public int idNastavnika() 	{ return idNastavnika; 	}
	public String ime() 		{ return ime; 			}
	public String prezime() 	{ return prezime; 		}
	public String zvanje() 		{ return zvanje; 		}

	
	public void setIdNastavnika(int idNastavnika) 	{ this.idNastavnika = idNastavnika; }
	public void setIme(String ime) 					{ this.ime = ime; 					}
	public void setPrezime(String prezime) 			{ this.prezime = prezime; 			}
	public void setZvanje(String zvanje) 			{ this.zvanje = zvanje; 			}
	
	
	@Override
	public String toString() {
		return String.format("%5d %20s %20s %10s %n", idNastavnika(), ime(), prezime(), zvanje());
	}
}
