package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoDoXadrez;

public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public  static  final  String  ANSI_RESET  =  "\u001B[0m";
	public  static  final  String  ANSI_BLACK  =  "\u001B[30m";
	public  static  final  String  ANSI_RED  =  "\u001B[31m";
	public  static  final  String  ANSI_GREEN  =  "\u001B[32m";
	public  static  final  String  ANSI_YELLOW  =  "\u001B[33m";
	public  static  final  String  ANSI_BLUE  =  "\u001B [34m";
	public  static  final  String  ANSI_PURPLE  =  "\u001B[35m";
	public  static  final  String  ANSI_CYAN  =  "\u001B[36m";
	public  static  final  String  ANSI_WHITE  =  "\u001B[37m";

	public  static  final  String  ANSI_BLACK_BACKGROUND  =  "\u001B[40m";
	public  static  final  String  ANSI_RED_BACKGROUND  =  "\u001B[41m";
	public  static  final  String  ANSI_GREEN_BACKGROUND  =  "\u001B[42m";
	public  static  final  String  ANSI_YELLOW_BACKGROUND  =  "\u001B[43m";
	public  static  final  String  ANSI_BLUE_BACKGROUND  =  "\u001B[44m";
	public  static  final  String  ANSI_PURPLE_BACKGROUND  =  "\u001B[45m";
	public  static  final  String  ANSI_CYAN_BACKGROUND  =  "\u001B[46m";
	public  static  final  String  ANSI_WHITE_BACKGROUND  =  "\u001B[47m";
	
	// Método pego em:
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void limparTela()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static PosicaoDoXadrez lendoAPosicao(Scanner tec)
	{
		try
		{
			String msg = tec.nextLine();
			char coluna = msg.charAt(0);
			int linha = Integer.parseInt(msg.substring(1));
		
			return new PosicaoDoXadrez(coluna, linha);
		}
		catch(RuntimeException e)
		{
			throw new InputMismatchException("Erro na leitura da posição. Posições válidas são de a1 à h8.");
		}
	}
	
	public static void imprimirPartida(PartidaXadrez partida, List<PecaXadrez> pecasCapturadas)
	{
		imprimeTabuleiro(partida.getPecas());
		System.out.println();
		imprimirPecasCapturadas(pecasCapturadas);
		System.out.println();
		System.out.println("Turno: " +partida.getTurno());
		System.out.println("Esperando o jogador da cor: " +partida.getJogadorAtual());
	}
	
	public static void imprimeTabuleiro(PecaXadrez[][] pecas)
	{
		for(int i = 0; i < pecas.length; i++)
		{
			System.out.print(8 - i + " ");
			for(int j = 0; j < pecas.length; j++)
			{
				imprimePeca(pecas[i][j], false);
			}
			System.out.println();
		}
		
		System.out.println("  a b c d e f g h");
	}
	
	public static void imprimeTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis)
	{
		for(int i = 0; i < pecas.length; i++)
		{
			System.out.print(8 - i + " ");
			for(int j = 0; j < pecas.length; j++)
			{
				imprimePeca(pecas[i][j], movimentosPossiveis[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("  a b c d e f g h");
	}
	
	public static void imprimePeca(PecaXadrez peca, boolean corDeFundo)
	{
		if(corDeFundo)
		{
			System.out.print(ANSI_BLUE_BACKGROUND );
		}
		
		if(peca == null) 
		{
            System.out.print("-" + ANSI_RESET);
        }
        else if (peca.getCor() == Cor.BRANCA) 
            {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else 
            {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        
        System.out.print(" ");
	
	}
	
	private static void imprimirPecasCapturadas(List<PecaXadrez> pecasCapturadas)
	{
		List<PecaXadrez> pecasBrancas = pecasCapturadas.stream().filter(x -> x.getCor() == Cor.BRANCA).collect(Collectors.toList());
		List<PecaXadrez> pecasPretas = pecasCapturadas.stream().filter(x -> x.getCor() == Cor.PRETA).collect(Collectors.toList());
		System.out.println("Peças Capturadas:");
		System.out.print("Brancas: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(pecasBrancas.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Pretas: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(pecasPretas.toArray()));
		System.out.print(ANSI_RESET);

	}
}
