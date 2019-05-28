import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meni {

	public static void meni() {

		List<Student> studenti = new ArrayList<>();
		List<Predmet> predmeti = new ArrayList<>();
		List<IspitnaPrijava> prijave = new ArrayList<>();
		List<IspitnaPrijava> polozeniIspiti = new ArrayList<>();

		Student s1 = new Student("Katarina", "Milutinovic", "127", 2005, 1986, 3, 26);
		Student s2 = new Student("Jelena", "Matejic", "128", 2005, 1985, 9, 10);
		Student s3 = new Student("Vanja", "Latinovic", "129", 2005, 1986, 11, 28);
		Student s4 = new Student("Mirjana", "Cvijetinovic", "130", 2005, 1985, 9, 3);
		Student s5 = new Student("Radmila", "Nenadovic", "131", 2005, 1981, 3, 15);
		Student s6 = new Student("Miloš", "Nikolic", "132", 2005, 1983, 6, 22);
		Student s7 = new Student("Dejan", "Paunic", "133", 2005, 1983, 3, 12);

		Predmet p1 = new Predmet(1, "Osnove programiranja - Java");
		Predmet p2 = new Predmet(2, "Osnove objektnog programiranja - Java");
		Predmet p3 = new Predmet(3, "Razvoj baza podataka - MySQL");
		Predmet p4 = new Predmet(4, "Napredne Java tehnologije");
		Predmet p5 = new Predmet(5, "Softverski paterni - Java");
		Predmet p6 = new Predmet(6, "Razvoj softvera koriscenjem Java tehnologija");

		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		studenti.add(s4);
		studenti.add(s5);
		studenti.add(s6);
		studenti.add(s7);

		predmeti.add(p1);
		predmeti.add(p2);
		predmeti.add(p3);
		predmeti.add(p4);
		predmeti.add(p5);
		predmeti.add(p6);

		Scanner unos = new Scanner(System.in);

		boolean kraj = false;
		int unosOpcija = 0;
		char unosPodopcija = 'a';

		do {
			System.out.println("");
			System.out.println("Odaberi jednu od sledecih opcija:" + "\n" 
									+ "1. Pregled" + "\n" 
									+ "2. Unos nove prijave" + "\n" 
									+ "3. Izmena" + "\n" 
									+ "4. Kraj programa" + "\n" + "\n" 
									+ "Unesi broj opcije:");

			try {
				unosOpcija = StandardniUlaz.prihvatiBrojPrekoSUlaza();
				if (unosOpcija < 1 || unosOpcija > 4) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Uneta pogrešna vrednost! Potrebno je odabrati opciju od 1 do 4.");
				continue;
			}

			switch (unosOpcija) {
			case 1:

				System.out.println("Odaberi jednu od podopcija:" + "\n" + " \t" 
										+ "a. Pregled svih predmeta" + "\n" + " \t" 
										+ "b. Pregled svih studenata" + "\n" + " \t"
										+ "c. Pregled svih prijava za trazenog studenta" + "\n" + " \t"
										+ "d. Prikaz svih studenata koji su polozili odredjeni predmet" + "\n" + " \t"
										+ "e. Povratak u glavni meni" + "\n" 
										+ "Unesi slovo opcije:");

				do {
				unosPodopcija = unos.next().charAt(0);
					if (unosPodopcija != 'a' && unosPodopcija != 'b' && unosPodopcija != 'c' && unosPodopcija != 'd'
						&& unosPodopcija != 'e') {
						System.out.println("Unet pogresan karakter! Dozvoljeni su samo karakteri a, b, c, d ili e! Unesi ponovo zeljenu opciju: ");
					}
				} while(unosPodopcija != 'a' && unosPodopcija != 'b' && unosPodopcija != 'c' && unosPodopcija != 'd'
						&& unosPodopcija != 'e');
				
				if (unosPodopcija == 'a') {

					System.out.println("Pregled svih predmeta:");
					int i = 1;
					for (Predmet predmet : predmeti) {
						System.out.println(i + ". " + predmet);
						i++;
					}
				}

				if (unosPodopcija == 'b') {

					System.out.println("Pregled svih studenata:");
					int i = 1;
					for (Student student : studenti) {
						System.out.println(i + ". " + student);
						i++;
					}
				}

				if (unosPodopcija == 'c') {

					if (!prijave.isEmpty()) {

						boolean nadjeno = false;
						do {
							System.out.println("Unesi broj indeksa:");

							String brojIndeksa = StandardniUlaz.prihvatiStringPrekoSUlaza();
							System.out.println("Sve prijave studenta sa brojem indeksa: " + brojIndeksa + ":");

							for (int i = 0; i < prijave.size(); i++) {
								if (brojIndeksa.equals(prijave.get(i).getStudent().getBrojIndeksa())) {
									System.out.println(prijave.get(i));
									nadjeno = true;
								}
							}

							if (!nadjeno) {
								System.out.println(
										"Ne postoji student sa navedenim brojem indeksa! Unesi ispravan broj!");
							}
						} while (!nadjeno);
					} else {
						System.out.println(
								"Jos uvek nema evidencije o prijavama! Potrebno je prvo uneti prijavu, opcija 2!");
					}
				}

				if (unosPodopcija == 'd') {

					if (!polozeniIspiti.isEmpty()) {

						boolean nadjeno = false;
						do {
							System.out.println("Unesi sifru predmeta:");

							int sifraPredmeta = 0;

							try {
								sifraPredmeta = StandardniUlaz.prihvatiBrojPrekoSUlaza();
								System.out.println(
										"Spisak studenata koji su polozili predmet pod sifrom: " + sifraPredmeta);

								for (Predmet predmet : predmeti) {
									if (predmet.getSifra() != sifraPredmeta) {
										throw new NumberFormatException();
									}
								}
							} catch (NumberFormatException nfe) {
								nadjeno = false;

							}

							for (int j = 0; j < predmeti.size(); j++) {
								if (sifraPredmeta == predmeti.get(j).getSifra()) {
									for (int i = 0; i < polozeniIspiti.size(); i++) {

										if (sifraPredmeta == polozeniIspiti.get(i).getPredmet().getSifra()) {

											System.out.println(polozeniIspiti.get(i));
											nadjeno = true;

										}
									}
								}
							}

							if (!nadjeno) {
								System.out.println("Ne postoji predmet sa navedenom sifrom! Unesi ispravnu sifru!");

							}

						} while (!nadjeno);

					} else {
						System.out.println(
								"Jos uvek nema evidencije o polozenim ispitima! Potrebno je prvo uneti prijavu, opcija 2!");
					}

				}

				if (unosPodopcija == 'e') {
					break;
				}

				break;

			case 2:

				int sifraPredmeta = 0;
				String brojIndeksa = null;
				String datumUnos = null;
				LocalDate datum = null;
				int ocena = 0;
				boolean prekid = false;

				do {
					try {
						System.out.println("Unesi šifru predmeta:");
						sifraPredmeta = StandardniUlaz.prihvatiBrojPrekoSUlaza();
					} catch (NumberFormatException nfe) {

					}

					for (int i = 0; i < predmeti.size(); i++) {
						if (sifraPredmeta == predmeti.get(i).getSifra()) {
							prekid = true;
						}
					}

					if (!prekid) {
						System.out.println("Navedena sifra ne postoji u bazi, unesi ispravan broj!");
					}

				} while (!prekid);

				do {

					System.out.println("Unesi broj indeksa:");
					brojIndeksa = StandardniUlaz.prihvatiStringPrekoSUlaza();

					for (int i = 0; i < studenti.size(); i++) {
						if (brojIndeksa.equals(studenti.get(i).getBrojIndeksa())) {
							prekid = false;
						}
					}
					if (prekid == true) {
						System.out.println("Navedeni broj indeksa ne postoji u bazi, unesi ispravan broj!");
					}

				} while (prekid);

				do {
					System.out.println("Unesi datum polaganja u formatu dd.MM.yyyy.:");
					datumUnos = StandardniUlaz.prihvatiStringPrekoSUlaza();

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

					try {
						datum = LocalDate.parse(datumUnos, formatter);
						prekid = true;
					} catch (Exception e) {
						System.out.println("Neispravan format, unesi datum u odgovarajućem formatu!");
					}
				} while (!prekid);

				System.out.println("Unesi ocenu:");
				System.out.println("Ukoliko je u pitanju prvo polaganje ili ispit nije polozen uneti 5");

				do {
					try {
						ocena = StandardniUlaz.prihvatiBrojPrekoSUlaza();
						if (ocena < 5 || ocena > 10) {
							throw new RuntimeException();
						}
					} catch (RuntimeException e) {
						System.out.println("Validne su ocene od 5 do 10! Unesi ocenu ponovo:");
					}
				} while (ocena < 5 || ocena > 10);

				for (Predmet predmet : predmeti) {
					if (predmet.getSifra() == sifraPredmeta) {
						for (Student student : studenti) {
							if (brojIndeksa.equals(student.getBrojIndeksa())) {

								if (ocena == 5) {
									prijave.add(new IspitnaPrijava(datum, ocena, student, predmet));
								}

								if (ocena > 5 && ocena < 11) { 
									prijave.add(new IspitnaPrijava(datum, ocena, student, predmet));

									if (!polozeniIspiti.isEmpty()) {
										boolean nadjeno = false;
										for (int i = 0; i < polozeniIspiti.size(); i++) {

											if (sifraPredmeta == polozeniIspiti.get(i).getPredmet().getSifra()
													&& brojIndeksa.equals(
															polozeniIspiti.get(i).getStudent().getBrojIndeksa())) {

												polozeniIspiti.get(i).setDatumPolaganja(datum);
												polozeniIspiti.get(i).setOcena(ocena);
												nadjeno = true;
											}
										}
										if (!nadjeno) {
											polozeniIspiti.add(new IspitnaPrijava(datum, ocena, student, predmet));

										}
									} else {
										polozeniIspiti.add(new IspitnaPrijava(datum, ocena, student, predmet));
										
									}
								}
							}
						}
					}
				}

				break;

			case 3:
				boolean ispravno = false;

				System.out.println("Odaberi jednu od podopcija:" + "\n" + " \t" 
										+ "a. Izmena podataka o studentu" + "\n" + " \t" 
										+ "b. Povratak u glavni meni" + "\n" 
										+ "Unesi slovo opcije:");

				do {
					unosPodopcija = unos.next().charAt(0);
					if (unosPodopcija != 'a' && unosPodopcija != 'b') {
						System.out.println("Unet pogresan karakter! Dozvoljeni su samo karakteri a ili b. Unesi ponovo zeljenu opciju: ");
					}
				} while (unosPodopcija != 'a' && unosPodopcija != 'b');

				if (unosPodopcija == 'a') {
					do {
						System.out.println("Unesi broj indeksa studenta cije podatke zelis da izmenis:");
						
						String brojIndeksaStudentaZaPromene = StandardniUlaz.prihvatiStringPrekoSUlaza();
							
						for (int i = 0; i < studenti.size(); i++) {
							if (brojIndeksaStudentaZaPromene.equals(studenti.get(i).getBrojIndeksa())) {
								System.out.println("Postojeci podaci o odabranom studentu su: " + studenti.get(i));

								System.out.println("Unesi nove podatke: ");
								
								System.out.println("Ime studenta: ");
								String novoIme = StandardniUlaz.prihvatiStringPrekoSUlaza();
								studenti.get(i).setIme(novoIme);
								
								System.out.println("Prezime studenta: ");
								String novoPrezime = StandardniUlaz.prihvatiStringPrekoSUlaza();
								studenti.get(i).setPrezime(novoPrezime);
								
								System.out.println("Broj indeksa studenta: ");
								String noviBrojIndeksa = StandardniUlaz.prihvatiStringPrekoSUlaza();
								studenti.get(i).setBrojIndeksa(noviBrojIndeksa);

								int novaGodinaUpisa = 0;
								prekid = false;
								do {
									try {
										System.out.println("Godina upisa je: ");
										novaGodinaUpisa = StandardniUlaz.prihvatiBrojPrekoSUlaza();
										prekid = true;
									} catch (NumberFormatException nfe) {
										System.out.println("Neispravan unos, dozvoljeni su samo numericki karakteri!");
									}
									studenti.get(i).setGodinaUpisa(novaGodinaUpisa);
								} while (!prekid);

								do {
									System.out.println("Datum rodjenja studenta (u formatu dd.MM.yyyy.): ");
									LocalDate noviDatum = null;
									String noviDatumUnos = StandardniUlaz.prihvatiStringPrekoSUlaza();
									DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

									try {
										noviDatum = LocalDate.parse(noviDatumUnos, formatter);

										studenti.get(i).setDatumRodjenja(noviDatum);
										prekid = false;
										System.out.println("Novi podaci studenta su: " + studenti.get(i));

									} catch (DateTimeParseException dtpe) {
										System.out.println("Neispravan format, unesi datum u odgovarajucem formatu!");
									}

								} while (prekid);

								ispravno = true;
							}

						}
						if (!ispravno) {
							System.out.println("Ne postoji student sa navedenim brojem indeksa! Unesi ispravan broj!");
						}
					} while (!ispravno);

				}

				if (unosPodopcija == 'b') {
					break;
				}
				break;
			case 4:
				kraj = true;
				unos.close();
				System.out.println("Kraj!");
				break;

			default:
				System.out.println("Unesi opet opciju!");

			}

		} while (!kraj);

	}

}
