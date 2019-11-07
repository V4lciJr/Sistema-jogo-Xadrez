package xadrez;

import jogotabuleiro.Peca;
import jogotabuleiro.Posicao;
import jogotabuleiro.Tabuleiro;
import pecaXadrez.Rei;
import pecaXadrez.Torre;

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
	
	public PecaXadrez movimento(PosicaoDoXadrez posicaoOrigem, PosicaoDoXadrez posicaoDestino)
	{
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validandoPosicaoInicial(origem);
		Peca pecaCapturada = mover(origem, destino);
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca mover(Posicao origem, Posicao destino)
	{
		Peca peca = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(peca, destino);
		return pecaCapturada;
	}
	private void validandoPosicaoInicial(Posicao origem)
	{
		if(!tabuleiro.possuiUmaPeca(origem))
		{
			throw new XadrezExcecao("Erro.Não existe peça na posição inicial!");
		}
		if(!tabuleiro.peca(origem).existeAlgumMovimento())
		{
			throw new XadrezExcecao("Não existe movimentos possíveis para a peça escolhida.");
		}
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca)
	{
		tabuleiro.colocarPeca(peca, new PosicaoDoXadrez(coluna, linha).posicionar());
	}
	
	public void InicioDePartida()
	{
		colocarNovaPeca( 'c' , 1 , new  Torre (tabuleiro, Cor.BRANCA));
        colocarNovaPeca( 'c' , 2 , new  Torre (tabuleiro, Cor.BRANCA));
        colocarNovaPeca ( 'd' , 2 , new  Torre (tabuleiro, Cor.BRANCA));
        colocarNovaPeca ( 'e' , 2 , new  Torre (tabuleiro, Cor.BRANCA));
        colocarNovaPeca ( 'e' , 1 , new  Torre (tabuleiro, Cor.BRANCA));
        colocarNovaPeca ( 'd' , 1 , new  Rei (tabuleiro, Cor.BRANCA));

        colocarNovaPeca ( 'c' , 7 , new  Torre (tabuleiro, Cor.PRETA));
        colocarNovaPeca ( 'c' , 8 , new  Torre (tabuleiro, Cor.PRETA));
        colocarNovaPeca( 'd' , 7 , new  Torre (tabuleiro, Cor.PRETA ));
        colocarNovaPeca ( 'e' , 7 , new  Torre (tabuleiro, Cor.PRETA ));
        colocarNovaPeca ( 'e' , 8 , new  Torre (tabuleiro, Cor.PRETA ));
        colocarNovaPeca ( 'd' , 8 , new  Rei (tabuleiro, Cor.PRETA ));
	}
}
