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

		for (int i = 0; i < mapa.length; i++) {
			System.out.println("");

			if (i == 0) {
				System.out.println("--------- .. Jogada: " + jogada);
			} else {
				System.out.println("---------");
			}

			for (int j = 0; j < mapa.length; j++) {
				if (i == 0 || i == 2) {
					System.out.print("|" + mapa[i][j] + "|");

				} else if (j == 0 || j == 2) {
					System.out.print("|" + mapa[i][j] + "|");

				} else {
					System.out.print(mapa[i][j]);
				}
			}

		}
	System.out.println("\n------------------");

	}

	public boolean jogar(int l, int c, char jogador) {

		if (mapa[l][c] == ' ') {
			mapa[l][c] = jogador;

			return true;

		} else {
			return false;

		}

	}

	public boolean ganhou(char jogador) {

		for (int i = 0; i < mapa.length; i++) {
			if (mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador) {
				return true;

			}

		}

		for (int j = 0; j < mapa.length; j++) {
			if (mapa[0][j] == jogador && mapa[1][j] == jogador && mapa[2][j] == jogador) {
				return true;

			}

		}

		if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) {
			return true;
		}

		if (mapa[2][0] == jogador && mapa[1][1] == jogador && mapa[0][2] == jogador) {
			return true;
		}

		return false;
	}

}
