import java.time.LocalDate;


public class IspitnaPrijava {
	LocalDate datumPolaganja;
	int ocena;
	Student student;
	Predmet predmet;
	
	public IspitnaPrijava(LocalDate datumPolaganja, int ocena, Student student, Predmet predmet) {
		super();
		this.datumPolaganja = datumPolaganja;
		this.ocena = ocena;
		this.student = student;
		this.predmet = predmet;
	}

	public LocalDate getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(LocalDate datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	@Override
	public String toString() {
		return "Student: " + student.getIme() + " " + student.getPrezime() + "\t" + " Broj indeksa: " + student.getBrojIndeksa() + "\t" 
				+ " Sifra predmeta: " + predmet.getSifra() + "\t" + " " + predmet.getNaziv() + "\t" + " Datum polaganja: " + ispisiDatumPolaganja() + "\t" + " Ocena: " + getOcena();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof IspitnaPrijava) {
			IspitnaPrijava i = (IspitnaPrijava) obj;
			return (getStudent().getBrojIndeksa().equals(i.getStudent().getBrojIndeksa()) && getPredmet().getSifra()==i.getPredmet().getSifra());
		}
		return false;
	}
	
	public String ispisiDatumPolaganja() {
		return datumPolaganja.getDayOfMonth() + "." + datumPolaganja.getMonthValue() + "." + datumPolaganja.getYear() + ".";
	}
	
}
