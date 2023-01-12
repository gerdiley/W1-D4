package it.epicode.w1.d4;

public class Dipendente {
	private static double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;

	// constructor 1

	public Dipendente(String matricola, Dipartimento dipartimento) {

		this.matricola = matricola;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}
	// constructor 2
	
	public Dipendente(String matricola, double stipendio, double importoOrarioStraordinario, Livello livello,
			Dipartimento dipartimento) {
		this( matricola, dipartimento);
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
	}

	
//	Getters e setters

	public double getStipendioBase() {
		return stipendioBase;
	}

	
	public String getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Livello getLivello() {
		return livello;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

//	metodi

	public void stampaDatiDipendente() {
		System.out.printf("Dati dipendente %n Matricola: %s %n Livello: " + this.getLivello() + "Dipartimento: "
				+ this.getDipartimento(), matricola);
	}

	public Livello promuovi() {

		if(this.livello == Livello.OPERAIO) {
			this.stipendio = Dipendente.stipendioBase * Livello.IMPIEGATO.getMoltiplicatoreStipendio();
			this.livello = Livello.IMPIEGATO;
			return Livello.IMPIEGATO;

		} else if(this.livello == Livello.IMPIEGATO) {
			this.stipendio = Dipendente.stipendioBase * Livello.QUADRO.getMoltiplicatoreStipendio();
			this.livello = Livello.QUADRO;
			return Livello.QUADRO;
		}
		else if(this.livello == Livello.QUADRO) {
			this.stipendio = Dipendente.stipendioBase * Livello.DIRIGENTE.getMoltiplicatoreStipendio();
			this.livello = Livello.DIRIGENTE;
			return Livello.DIRIGENTE;
		} else if(this.livello == Livello.DIRIGENTE) {
			System.out.println("Impossibile effettuare la promozione poiche` il dipendente con matricola: " + this.getMatricola() + "e` gia` dirigente ");
			return Livello.DIRIGENTE;
		} else {
			System.out.println("Impossibile effettuare la promozione poiche` il livello e` sconosciuto");
			
			return this.livello;
		}
	}

	public static double calcolaPaga(Dipendente d) {
		return d.getStipendio();
	}

	public static double calcolaPagaStraordinario(Dipendente d, int ore) {
		return d.getImportoOrarioStraordinario() * ore;
	}

}
