public class JogoDaVelha_PC {

	private JogoDaVelha_Mapa mapa;
	private char letra;

	public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
		this.letra = 'O';
	}

	public JogoDaVelha_Mapa getMapa() {
		return mapa;
	}

	public void setMapa(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public boolean joga() {

		int linha;
		int coluna;

		do {

			linha = mapa.sortear(0, 3);
			coluna = mapa.sortear(0, 3);

		} while (!mapa.jogar(linha, coluna, letra));
		
		System.out.println("PC[" + linha + ", " + coluna + "]");

		if (mapa.ganhou(letra)) {
			System.out.println("...PC GANHOU!");
		}

		return true;
	}

}
