package prakticne_vezbe.pv04_z01;

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
	public String zvanje() 			{ return zvanje; 		}
	

	public void setIdNastavnika(int idNastavnika) 	{ this.idNastavnika = idNastavnika; }
	public void setIme(String ime) 					{ this.ime = ime; 					}
	public void setPrezime(String prezime) 			{ this.prezime = prezime; 			}
	public void setZvanje(String zvanje) 			{ this.zvanje = zvanje; 			}


	@Override
	public String toString() {
		return "Nastavnik [idNastavnika=" + idNastavnika + ", ime=" + ime + ", prezime=" + prezime + ", zvanje="
				+ zvanje + "]";
	}
}
