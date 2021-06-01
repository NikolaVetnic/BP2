package kolokvijum;

public class Knjiga {

	
	private int inventarniBroj;
	private String naslov;
	private int godinaIzdanja;
	
	
	public Knjiga() {}
	
	
	public Knjiga(int inventarniBroj, String naslov, int godinaIzdanja) {
		this.inventarniBroj = inventarniBroj;
		this.naslov = naslov;
		this.godinaIzdanja = godinaIzdanja;
	}


	public int inventarniBroj() { return inventarniBroj; 	}
	public String naslov() 		{ return naslov; 			}
	public int godinaIzdanja() 	{ return godinaIzdanja; 	}
	
	
	@Override
	public String toString() {
		return String.format("%d %s %d", inventarniBroj(), naslov(), godinaIzdanja());
	}
}
