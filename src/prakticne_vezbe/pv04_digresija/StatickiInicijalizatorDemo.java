package prakticne_vezbe.pv04_digresija;

public class StatickiInicijalizatorDemo {

	
	public StatickiInicijalizatorDemo() {
		System.out.println("Ovo je konstruktor");
	}
	
	
	static { 
		System.out.println("Ovo je staticki inicijalizator");
	}
	
	
	{
		System.out.println("Ovo je nestaticki inicijalizator");
	}
	
	
	public static void main(String[] args) {
		
		StatickiInicijalizatorDemo p0 = new StatickiInicijalizatorDemo();
		StatickiInicijalizatorDemo p1 = new StatickiInicijalizatorDemo();
	}
}
