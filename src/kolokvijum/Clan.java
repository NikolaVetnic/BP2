package kolokvijum;

public class Clan {

	
	private int clanskiBroj;
	private String ime;
	private String prezime;
	private String adresa;
	
	
	public Clan() {}
	
	
	public Clan(int clanskiBroj, String ime, String prezime, String adresa) {
		this.clanskiBroj = clanskiBroj;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	}


	public int clanskiBroj() 	{ return clanskiBroj; 	}
	public String ime() 		{ return ime; 			}
	public String prezime() 	{ return prezime; 		}
	public String adresa() 		{ return adresa; 		}
	
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", clanskiBroj(), ime(), prezime(), adresa());
	}
}
