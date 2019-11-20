package xadrez;

import jogotabuleiro.Peca;
import jogotabuleiro.Posicao;
import jogotabuleiro.Tabuleiro;
import pecaXadrez.Bispo;
import pecaXadrez.Cavalo;
import pecaXadrez.Peao;
import pecaXadrez.Rainha;
import pecaXadrez.Rei;
import pecaXadrez.Torre;

public class PartidaXadrez {
	
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	
	
	public PartidaXadrez()
	{
		tabuleiro = new Tabuleiro(8,8);
		turno = 1;
		jogadorAtual = Cor.BRANCA;
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
	
	public int getTurno()
	{
		return turno;
	}
	
	public Cor getJogadorAtual()
	{
		return jogadorAtual;
	}
	
	public void proximoTurno()
	{
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
	}
	
	public PecaXadrez movimento(PosicaoDoXadrez posicaoOrigem, PosicaoDoXadrez posicaoDestino)
	{
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validandoPosicaoInicial(origem);
		validandoPosicaoDestino(origem, destino);
		Peca pecaCapturada = mover(origem, destino);
		proximoTurno();
		return (PecaXadrez)pecaCapturada;
	}
	
	public boolean[][] movimentosPossiveis(PosicaoDoXadrez origem)
	{
		Posicao posicao = origem.posicionar();
		validandoPosicaoInicial(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
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
		if(jogadorAtual != ((PecaXadrez)tabuleiro.peca(origem)).getCor())
		{
			throw new XadrezExcecao("A peça escolhida não é sua!");
		}
	}
	
	private void validandoPosicaoDestino(Posicao origem, Posicao destino)
	{
		if(!tabuleiro.peca(origem).movimentoPossivel(destino))
		{
			throw new XadrezExcecao("A peça escolhida, não pode ser movida para a posição de destino");
		}
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca)
	{
		tabuleiro.colocarPeca(peca, new PosicaoDoXadrez(coluna, linha).posicionar());
	}
	
	public void InicioDePartida()
	{
		colocarNovaPeca( 'a' , 1 , new Torre (tabuleiro, Cor.BRANCA));
        colocarNovaPeca('b', 1 , new Cavalo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('c', 1 , new Bispo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('d', 1 , new Rainha(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('e', 1 , new Rei(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('f', 1 , new Bispo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('g', 1 , new Cavalo(tabuleiro, Cor.BRANCA));
        colocarNovaPeca('h', 1 , new Torre(tabuleiro, Cor.BRANCA));
        for(int i = 0; i < 8; i++)
        {
        	colocarNovaPeca((char) ('a' + (char)i) , 2 , new Peao(tabuleiro, Cor.BRANCA));
        	colocarNovaPeca((char) ('a' + (char)i) , 7 , new Peao(tabuleiro, Cor.PRETA));
        }

        colocarNovaPeca( 'a' , 8 , new Torre (tabuleiro, Cor.PRETA));
        colocarNovaPeca('b', 8 , new Cavalo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('c', 8 , new Bispo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('d', 8 , new Rainha(tabuleiro, Cor.PRETA));
        colocarNovaPeca('e', 8 , new Rei(tabuleiro, Cor.PRETA));
        colocarNovaPeca('f', 8 , new Bispo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('g', 8 , new Cavalo(tabuleiro, Cor.PRETA));
        colocarNovaPeca('h', 8 , new Torre(tabuleiro, Cor.PRETA));
	}
}
