package jogador;
import java.util. *;

public class JogadorController {
	protected ArrayList<Jogador> jogadores;
	protected int numJogadores;

	public JogadorController(int numJogadores){
		this.numJogadores = numJogadores;
		this.jogadores = new ArrayList<>();
	}	

	public int getNumJogadores() { return numJogadores; }

	public void criarJogadores(){
		for (int i = 0; i < this.numJogadores; i++){
			this.jogadores.add(new Jogador(i));
		}
	}

	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}

	public Jogador getJogadorById(int id){
		Jogador jogador = this.jogadores.get(id);
		return jogador;
	}

	public void atualizarCasaAtual(int id, int numCasas){
		Jogador jogador = this.jogadores.get(id);
		int casaAtual = jogador.getCasaAtual();
		//if((casaAtual+numCasas) >= 40)
		//	this.atualizarCarteira(id, 200);
		jogador.setCasaAtual((casaAtual+numCasas) % 40);
	}

	public void atualizarCarteira(int id, int dinheiro){
		Jogador jogador = this.jogadores.get(id);
		int carteira = jogador.getCarteira();
		jogador.setCarteira(carteira+dinheiro);
	}

	public void eliminarJogador(int id){
		Jogador jogador = this.jogadores.get(id);
		jogador.atualizarEstado();
	}

	public void comprarCasa(int idJogador, int idCasa){
		Jogador jogador = this.jogadores.get(idJogador);

		HashSet<Integer> casasCompraveis = jogador.getCasasCompraveis();
		casasCompraveis.remove(idCasa);

		HashSet<Integer> casasCompradas = jogador.getCasasCompradas();
		casasCompradas.add(idCasa);
	}

	public void venderCasa(int idJogador, int idCasa){
		Jogador jogador = this.jogadores.get(idJogador);

		HashSet<Integer> casasCompraveis = jogador.getCasasCompraveis();
		casasCompraveis.add(idCasa);

		HashSet<Integer> casasCompradas = jogador.getCasasCompradas();
		casasCompradas.remove(idCasa);
	}

	public void adicionarCasaCompravel(int idJogador, int idCasa){
		Jogador jogador = this.jogadores.get(idJogador);
		HashSet<Integer> casasCompraveis = jogador.getCasasCompraveis();
		casasCompraveis.add(idCasa);
	}

	public void removerCasaCompravel(int idJogador, int idCasa){
		Jogador jogador = this.jogadores.get(idJogador);
		HashSet<Integer> casasCompraveis = jogador.getCasasCompraveis();
		casasCompraveis.remove(idCasa);
	}
}
