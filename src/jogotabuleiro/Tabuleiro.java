package jogotabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas)
	{
		if(linhas < 1 || colunas < 1)
		{
			throw new TabuleiroExcecao("Erro na cria��o do tabuleiro, � necess�rio ao menos uma linha e uma linha coluna !!");
		}
		
		this.colunas = colunas;
		this.linhas = linhas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
		
	public Peca peca(int linha, int coluna)
	{
		if(!posicaoExistente(linha, coluna))
		{
			throw new TabuleiroExcecao("N�o existe esta posi��o no seu tabuleiro.");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao)
	{
		if(!posicaoExistente(posicao))
		{
			throw new TabuleiroExcecao("N�o existe esta posi��o no seu tabuleiro.");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao)
	{
		if(possuiUmaPeca(posicao))
		{
			throw new TabuleiroExcecao("Erro ao colocar pe�a. J� existe uma pe�a nessa posi��o " +posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()]= peca;
		peca.posicao = posicao;
	}
	
	private boolean posicaoExistente(int linha, int coluna)
	{
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExistente(Posicao posicao)
	{
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	public Peca removerPeca(Posicao posicao)
	{
		if(!posicaoExistente(posicao))
		{
			throw new TabuleiroExcecao("N�o existe esta posi��o no seu tabuleiro.");
		}
		if(peca(posicao) == null)
		{
			return null;
		}
		
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	
	public boolean possuiUmaPeca(Posicao posicao)
	{
		if(!posicaoExistente(posicao))
		{
			throw new TabuleiroExcecao("N�o existe esta posi��o no seu tabuleiro.");
		}
		return peca(posicao) != null;
	}
}
