import java.util.Scanner;

public class JogoDaVelha {

	private JogoDaVelha_Mapa jogoMapa = new JogoDaVelha_Mapa();
	private JogoDaVelha_PC jogoPC = new JogoDaVelha_PC(jogoMapa);
	private JogoDaVelha_Jogador jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

	private void jogar(Scanner teclado) {

		int jogada = 0;

		boolean alguemGanhou = false;

		int vezJogada = jogoMapa.sortear(1, 3);

		jogoMapa.limpaMapa();

		jogoMapa.desenha(jogada);

		while (!alguemGanhou && jogada < 9) {

			if (vezJogada == 1) {

				jogada++;
				jogoJogador.joga(teclado);
				jogoMapa.desenha(jogada);

				if (jogoMapa.ganhou(jogoJogador.getLetra())) {
					alguemGanhou = true;
					break;
				}
				
				//Como o jogador começa, a última jogada vai ser dele.
				//Se todos os campos forem preenchidos e ninguém ganhar, o jogo empata.
				if (alguemGanhou == false && jogada == 9) {
					System.out.print("... EMPATOU!");
					break;
				}

				jogada++;
				jogoPC.joga();
				jogoMapa.desenha(jogada);
				
				if (jogoMapa.ganhou(jogoPC.getLetra()) ) {
					alguemGanhou = true;
					break;
				}
				
				

			} else {

				jogada++;
				jogoPC.joga();
				jogoMapa.desenha(jogada);

				if (jogoMapa.ganhou(jogoPC.getLetra())) {
					alguemGanhou = true;
					break;

				}
				
				if (alguemGanhou == false && jogada == 9) {
					System.out.print("... EMPATOU!");
					break;
				}

				jogada++;
				jogoJogador.joga(teclado);
				jogoMapa.desenha(jogada);
				
				if (jogoMapa.ganhou(jogoJogador.getLetra()) ) {
					alguemGanhou = true;
					break;
				}

			}

		}

	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		JogoDaVelha jogoDaVelha = new JogoDaVelha();

		char opcao = 's';

		while (opcao == 's' || opcao == 'S') {

			jogoDaVelha.jogar(teclado);

			System.out.println("\n____________________________________");
			System.out.println("Deseja jogar novamente? (s/n)");
			opcao = teclado.next().charAt(0);

		}

	}

}
