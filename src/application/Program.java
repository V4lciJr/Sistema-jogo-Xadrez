package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoDoXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		PartidaXadrez partida = new PartidaXadrez();
		
		while(true)
		{
			UI.imprimeTabuleiro(partida.getPecas());
			System.out.println();
			System.out.print("Posição de Origem: ");
			PosicaoDoXadrez origem = UI.lendoAPosicao(tec);
			
			System.out.println();
			System.out.print("Posição de Destino: ");
			PosicaoDoXadrez destino = UI.lendoAPosicao(tec);
			
			PecaXadrez pecaCapturada = partida.movimento(origem, destino);
		}
	}

}
