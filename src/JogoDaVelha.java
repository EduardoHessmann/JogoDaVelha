import java.util.Scanner;

public class JogoDaVelha {

	private JogoDaVelha_Mapa jogoMapa = new JogoDaVelha_Mapa();
	private JogoDaVelha_PC jogoPC = new JogoDaVelha_PC(jogoMapa);
	private JogoDaVelha_Jogador jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

	private void jogar(Scanner teclado) {

		int jogada = 0;

		jogoMapa.desenha(jogada);
		
		int vezJogada = jogoMapa.sortear(1, 3);

		if (vezJogada == 1) {
			while (!jogoMapa.ganhou('X')) {

				
				jogada++;
				jogoJogador.joga(teclado);
				jogoMapa.desenha(jogada);
				vezJogada = 2;
				
				if (vezJogada == 2) {
					
				jogada++;
				jogoPC.joga();
				jogoMapa.desenha(jogada);
				
				}
			}
		} else {
			while (!jogoMapa.ganhou('O')) {

				jogada++;
				jogoPC.joga();
				jogoMapa.desenha(jogada);
				vezJogada = 1;

				if(vezJogada == 1) {
				jogada++;
				jogoJogador.joga(teclado);
				jogoMapa.desenha(jogada);
				}

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
