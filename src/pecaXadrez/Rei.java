package pecaXadrez;

import jogotabuleiro.Posicao;
import jogotabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString()
	{
		return "K";
	}
	
	
	private boolean podeMover(Posicao posicao)
	{
		PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(posicao);
		return peca == null || peca.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao aux = new Posicao(0,0);
		
		// Movimento pra cima
		aux.setValor(posicao.getLinha() - 1, posicao.getColuna());
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux))
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento pra baixo
		aux.setValor(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().posicaoExistente(aux) && podeMover(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento pra esquerda
		aux.setValor(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExistente(aux) && podeMover(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento pra direita
		aux.setValor(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExistente(aux) && podeMover(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento pra noroeste
		aux.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExistente(aux) && podeMover(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento pra nordeste
		aux.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExistente(aux) && podeMover(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento sul
		aux.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExistente(aux) && podeMover(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento sudeste
		aux.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExistente(aux) && podeMover(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		return matriz;
	}
}
