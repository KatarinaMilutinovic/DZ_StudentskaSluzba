import java.time.LocalDate;

public class Student {
	private String brojIndeksa;
	private int godinaUpisa;
	private String ime;
	private String prezime;
	LocalDate datumRodjenja;
	
	public Student(String ime, String prezime, String brojIndeksa, int godinaUpisa, int godina, int mesec, int dan) {
		this.ime = ime;
		this.prezime = prezime;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.datumRodjenja = LocalDate.of(godina, mesec, dan);
	}
	
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	@Override
	public String toString() {
		return ime + " " + prezime + "\t" + " broj indeksa: " + brojIndeksa + "\t" + " upisan/a: " + godinaUpisa + ".godine " + "\t" + " rodjen/a: " + ispisiDatumRodjenja();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student) obj;
			return brojIndeksa.equals(s.getBrojIndeksa());
		}
		return false;
	}
	
	public String ispisiDatumRodjenja() {
		return datumRodjenja.getDayOfMonth() + "." + datumRodjenja.getMonthValue() + "." +
				datumRodjenja.getYear() + ". godine";
	}
	
	public void postaviDatumRodjenja(int godina, int mesec, int dan) {
		datumRodjenja = LocalDate.of(godina, mesec, dan);
	}

}