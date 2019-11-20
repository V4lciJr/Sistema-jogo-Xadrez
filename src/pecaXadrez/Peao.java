package pecaXadrez;

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
	public boolean[][] movimentosPossiveis() {
		// TODO Auto-generated method stub
		return null;
	}

}
