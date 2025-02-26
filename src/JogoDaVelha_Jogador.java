import java.util.Scanner;

public class JogoDaVelha_Jogador {

	private JogoDaVelha_Mapa mapa;
	private char letra;

	public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
		this.letra = 'X';
	}

	public boolean joga(Scanner teclado) {

		int linha;
		int coluna;
			
		do {
			
			System.out.println("Jogador ..");

			System.out.println("Linha: ");
			linha = teclado.nextInt();
			System.out.println("Coluna");
			coluna = teclado.nextInt();
			
		} while (!mapa.jogar(linha, coluna, letra));
		
		if (mapa.ganhou(letra)) {
			
			System.out.println("...JOGADOR GANHOU!");
			
			return true;
		}

		return false;
	}

}