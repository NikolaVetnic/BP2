package kolokvijum;

public class Iznajmljuje {

	
	private int clanskiBroj;
	private int inventarniBroj;
	private String datum;
	
	
	public Iznajmljuje() {}
	
	
	public Iznajmljuje(int clanskiBroj, int inventarniBroj, String datum) {
		this.clanskiBroj = clanskiBroj;
		this.inventarniBroj = inventarniBroj;
		this.datum = datum;
	}


	public int clanskiBroj() 	{ return clanskiBroj; 		}
	public int inventarniBroj()	{ return inventarniBroj; 	}
	public String datum()		{ return datum; 			}
	
	
	@Override
	public String toString() {
		return String.format("%d %d %s", clanskiBroj(), inventarniBroj(), datum());
	}
}
