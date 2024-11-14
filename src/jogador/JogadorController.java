import java.util.*;
import jogador.Jogador;

package Jogador;

public class JogadorController {
	protected ArrayList<Jogador> jogadores;
	protected int numJogadores;

	public JogadorController(int numJogadores){
		this.numJogadores = numJogadores;
	}	

	public void criarJogadores(){
		for (int i = 0; i < this.numJogadores; i++){
			this.jogadores.add(new Jogador(i));
		}
	}

	public ArrayList<jogador> getJogadores(){
		return this.jogadores;
	}

	public Jogador getJogador(){
		Jogador jogador = this.jogadores.get(id);
		return jogador;
	}

	public void atualizarCasaAtual(int id, int numCasas){
		Jogador jogador = this.jogadores.get(id);
		int casaAtual = jogador.getCasaAtual;
		jogador.setCasaAtual(casaAtual+numCasas);
	}

	public void atualizarCarteira(int id, int dinheiro){
		Jogador jogador = this.jogadores.get(id);
		int carteira = jogador.getCarteira;
		jogador.atualizarCarteira(carteira+dinheiro);
	}

	public void eliminarJogador(int id){
		Jogador jogador = this.jogadores.get(id);
		jogador.atualizarEstado();
	}

	public void adicionarCasaCompravel(int idJogador, int idCasa){
		Jogador.jogador = this.jogadores.get(id);
		HashSet<int> casasCompraveis = jogador.getCasasCompraveis();
		casasCompraveis.add(idCasa);
	}
	
	public void adicionarCasaComprada(int idJogador, int idCasa){
		Jogador.jogador = this.jogadores.get(id);
		HashSet<int> casasCompradas = jogador.getCasasCompradas();
		casasCompradas.add(idCasa);
	}

	public void removerCasaCompravel(int idJogador, int idCasa){
		Jogador.jogador = this.jogadores.get(id);
		HashSet<int> casasCompraveis = jogador.getCasasCompraveis();
		casasCompraveis.remove(idCasa);
	}

	public void removerCasaComprada(int idJogador, int idCasa){
		Jogador.jogador = this.jogador.get(id);
		HashSet<int> casasCompradas = jogador.getCasaComprada();
		casasCompradas.remove(idCasa);
	}

}
