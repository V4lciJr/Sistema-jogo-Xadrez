package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoDoXadrez;
import xadrez.XadrezExcecao;

public class Program {

	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		PartidaXadrez partida = new PartidaXadrez();
		
		while(true)
		{
			try
			{
				UI.limparTela();
				UI.imprimirPartida(partida);
				System.out.println();
				System.out.print("Posição de Origem: ");
				PosicaoDoXadrez origem = UI.lendoAPosicao(tec);
				
				boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
				UI.limparTela();
				UI.imprimeTabuleiro(partida.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Posição de Destino: ");
				PosicaoDoXadrez destino = UI.lendoAPosicao(tec);
				
				PecaXadrez pecaCapturada = partida.movimento(origem, destino);
			}
			catch(XadrezExcecao e)
			{
				System.out.println(e.getMessage());
				tec.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.out.println(e.getMessage());
				tec.nextLine();
			}
		}
		
		
	}

}
