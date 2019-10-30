package jogotabuleiro;

public class Peca {
	
	protected Posicao position;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro)
	{
		this.tabuleiro = tabuleiro;
		position = null;
	}
	
	protected Tabuleiro getTabuleiro()
	{
		return tabuleiro;
	}
}
