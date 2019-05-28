
public class Predmet {
	private int sifra;
	private String naziv;
	
	public Predmet() {	
	}
	
	public Predmet(int sifra, String naziv) {
		this.sifra = sifra;
		this.naziv = naziv;
	}
	
	public int getSifra() {
		return sifra;
	}
	
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	@Override
	public String toString() {
		return "Sifra predmeta: " + sifra + "\t" + naziv;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Predmet) {
			Predmet p = (Predmet) obj;
			return (naziv.equals(p.getNaziv()) && sifra==p.getSifra());
		}
		return false;
	}
	
}
