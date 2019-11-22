package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import jogotabuleiro.Peca;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoDoXadrez;
import xadrez.XadrezExcecao;

public class Program {

	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		PartidaXadrez partida = new PartidaXadrez();
		
		List<PecaXadrez> capturadas = new ArrayList<>();
		
		while(true)
		{
			try
			{
				UI.limparTela();
				UI.imprimirPartida(partida, capturadas);
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
				
				if(pecaCapturada != null)
				{
					capturadas.add(pecaCapturada);
				}
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
