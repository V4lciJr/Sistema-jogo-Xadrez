package pecaXadrez;

import jogotabuleiro.Posicao;
import jogotabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString()
	{
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao aux = new Posicao(0,0);
		
		// Movimento a peça pra cima
		aux.setValor(posicao.getLinha() - 1, posicao.getColuna());
		
		while(getTabuleiro().posicaoExistente(aux) && !getTabuleiro().possuiUmaPeca(aux))
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
			aux.setLinha(aux.getLinha() - 1);
		}
		if(getTabuleiro().posicaoExistente(aux) && existePecaAdversaria(aux))
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento a peça pra esquerda
		aux.setValor(posicao.getLinha(), posicao.getColuna() - 1);

		while (getTabuleiro().posicaoExistente(aux) && !getTabuleiro().possuiUmaPeca(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
			aux.setColuna(aux.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExistente(aux) && existePecaAdversaria(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento  a pecça pra direita
		aux.setValor(posicao.getLinha(), posicao.getColuna() + 1);

		while (getTabuleiro().posicaoExistente(aux) && !getTabuleiro().possuiUmaPeca(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
			aux.setColuna(aux.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExistente(aux) && existePecaAdversaria(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Movimento a peça pra baixo
		aux.setValor(posicao.getLinha() + 1, posicao.getColuna());

		while (getTabuleiro().posicaoExistente(aux) && !getTabuleiro().possuiUmaPeca(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
			aux.setLinha(aux.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExistente(aux) && existePecaAdversaria(aux)) 
		{
			matriz[aux.getLinha()][aux.getColuna()] = true;
		}
				
		return matriz;
	}
}
