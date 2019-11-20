package pecaXadrez;

import jogotabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez{

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString()
	{
		return "C";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		// TODO Auto-generated method stub
		return null;
	}

}
