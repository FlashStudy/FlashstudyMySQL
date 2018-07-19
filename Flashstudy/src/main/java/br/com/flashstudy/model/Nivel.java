package br.com.flashstudy.model;

public enum Nivel {
	FACIL(1), MEDIO(2), DIFICIL(3);

	public int dificuldade;

	Nivel(int dif) {
		dificuldade = dif;
	}

	public int getDificuldade() {
		return dificuldade;
	}
}
