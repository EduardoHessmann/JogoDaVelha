public class JogoDaVelha_PC {

	private JogoDaVelha_Mapa mapa;
	private char letra;

	public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
		this.letra = 'O';
	}

	public boolean joga() {

		int linha;
		int coluna;

		do {
			
			linha = mapa.sortear(0, 3);
			coluna = mapa.sortear(0, 3);
			
		} while (!mapa.jogar(linha, coluna, letra));
			
		if (mapa.ganhou(letra)) {
			System.out.println("...PC GANHOU!");
		}
		
		System.out.println("PC(" + linha + ", " + coluna + ")");

		return true;
	}

}
