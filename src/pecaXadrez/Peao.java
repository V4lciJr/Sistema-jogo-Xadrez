package pecaXadrez;

import jogotabuleiro.Posicao;
import jogotabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString()
	{
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis() 
	{
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao posicao = new Posicao(0,0);
		
		posicao.setValor(posicao.getLinha(), posicao.getColuna());
		
		matriz [posicao.getLinha()][posicao.getColuna()] = true;
		
		return matriz;
	}

}
