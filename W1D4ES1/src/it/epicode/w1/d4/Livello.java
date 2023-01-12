package it.epicode.w1.d4;

public enum Livello {
	OPERAIO(1.0),
	IMPIEGATO(1.2),
	QUADRO(1.5),
	DIRIGENTE(2);
	
	private double moltiplicatoreStipendio;

	private Livello(double moltiplicatoreStipendio) {
		this.moltiplicatoreStipendio = moltiplicatoreStipendio;
	}

	public double getMoltiplicatoreStipendio() {
		return moltiplicatoreStipendio;
	}
	
	
	
	
}
