import java.util.Scanner;

public class JogoDaVelha {

	private JogoDaVelha_Mapa jogoMapa = new JogoDaVelha_Mapa();
	private JogoDaVelha_PC jogoPC = new JogoDaVelha_PC(jogoMapa);
	private JogoDaVelha_Jogador jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

	private void jogar(Scanner teclado) {

		int jogada = 0;

		jogoMapa.desenha(0);

		if (jogoMapa.sortear(1, 3) == 1) {
			while (!jogoMapa.ganhou('X')) {

				jogada++;
				jogoJogador.joga(teclado);

				jogoMapa.desenha(jogada);
				
				jogada++;
				jogoPC.joga();

				jogoMapa.desenha(jogada);

			}
		} else {
			while (!jogoMapa.ganhou('O')) {

				jogada++;
				jogoPC.joga();

				jogoMapa.desenha(jogada);

				jogada++;
				jogoJogador.joga(teclado);

				jogoMapa.desenha(jogada);

			}

		}

	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		JogoDaVelha jogoDaVelha = new JogoDaVelha();

		char opcao = 's';

		jogoDaVelha.jogar(teclado);

	}

}
