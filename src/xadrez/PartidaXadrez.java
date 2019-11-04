package xadrez;

import jogotabuleiro.Tabuleiro;
import pecaXadrez.Rei;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	
	public PartidaXadrez()
	{
		tabuleiro = new Tabuleiro(8,8);
		InicioDePartida();
	}
	
	public PecaXadrez[][] getPecas()
	{
		PecaXadrez[][] matrix = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for(int i = 0; i < tabuleiro.getLinhas(); i++)
		{
			for(int j = 0; j < tabuleiro.getColunas(); j++)
			{
				matrix[i][j] = (PecaXadrez)tabuleiro.peca(i, j);
			}
		}
		
		return matrix;
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca)
	{
		tabuleiro.colocarPeca(peca, new PosicaoDoXadrez(coluna, linha).posicionar());
	}
	
	public void InicioDePartida()
	{
		colocarNovaPeca('e', 8 , new Rei(tabuleiro, Cor.PRETA));
	}
}
