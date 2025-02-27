import java.util.Random;

public class JogoDaVelha_Mapa {

	private char[][] mapa;

	
	public JogoDaVelha_Mapa() {

		mapa = new char[3][3];
		limpaMapa();
	}

	public int sortear(int inicio, int fim) {

		Random random = new Random();

		return random.nextInt(inicio, fim);
	}

	public void limpaMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa.length; j++) {
				mapa[i][j] = ' ';
			}
		}

	}
	
	public void desenha(int jogada) {

		//Percorre as linhas, deixando uma quebra de linha a cada nova linha.
		for (int i = 0; i < mapa.length; i++) {
			System.out.println("");

			if (i == 0) {
				System.out.println("------- .. Jogada: " + jogada);
			} else {
				System.out.println("-------");
			}

			for (int j = 0; j < mapa[i].length; j++) {
				
				if (j == 0 || j == 2) {
					System.out.print("|" + mapa[i][j] + "|");

				} else {
					System.out.print(mapa[i][j]);
				}
			}

		}
		System.out.println("\n------------------");

	}

	public boolean jogar(int l, int c, char jogador) {

		//Testa se a jogada está dentro do limite do mapa.
		//Testa se a posição no vetor está vaga.
		if (mapa[l][c] == ' ' && l >= 0 && l <= 2 && c >= 0 && c <= 2) {
			mapa[l][c] = jogador;

			return true;

		} else {
			if (jogador == 'X') {
				System.out.println("Jogada inválida! Escolha a posição novamente.");

				return false;

			} else {
				return false;

			}

		}

	}

	public boolean ganhou(char jogador) {

		// linhas
		if (mapa[0][0] == jogador && mapa[0][1] == jogador && mapa[0][2] == jogador
				|| mapa[1][0] == jogador && mapa[1][1] == jogador && mapa[1][2] == jogador
				|| mapa[2][0] == jogador && mapa[2][1] == jogador && mapa[2][2] == jogador) {
			return true;

		}

		// colunas
		if (mapa[0][0] == jogador && mapa[1][0] == jogador && mapa[2][0] == jogador
				|| mapa[0][1] == jogador && mapa[1][1] == jogador && mapa[2][1] == jogador
				|| mapa[0][2] == jogador && mapa[1][2] == jogador && mapa[2][2] == jogador) {
			return true;

		}

		// diagonais
		if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador
				|| mapa[2][0] == jogador && mapa[1][1] == jogador && mapa[0][2] == jogador) {
			return true;
		}

		return false;
	}

}
