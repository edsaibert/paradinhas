package jogador;
import java.util. *;
import casa.*;
import javafx.scene.shape.Rectangle;

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
		if((casaAtual+numCasas) >= 40)
			this.atualizarCarteira(id, 200);
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

	public void hipotecarCasa(int idJogador, int idCasa){
		Jogador jogador = this.jogadores.get(idJogador);

		HashSet<Integer> casasHipotecadas = jogador.getCasasHipotecadas();
		casasHipotecadas.add(idCasa);

		HashSet<Integer> casasCompradas = jogador.getCasasCompradas();
		casasCompradas.remove(idCasa);
	}

	public void DeshipotecarCasa(int idJogador, int idCasa){
		Jogador jogador = this.jogadores.get(idJogador);

		HashSet<Integer> casasHipotecadas = jogador.getCasasHipotecadas();
		casasHipotecadas.remove(idCasa);

		HashSet<Integer> casasCompradas = jogador.getCasasCompradas();
		casasCompradas.add(idCasa);
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

	public void desenharJogador(int idJogador, int numDados, CasaController casas){
		Jogador jogador = this.jogadores.get(idJogador);
		Casa casa;
		int xAtual; int yAtual;

		System.out.println("idCasa: " + (jogador.casaAtual+numDados) + " idCasaAtual: " + jogador.casaAtual);

		for (int i = jogador.casaAtual; i <= jogador.casaAtual + numDados; i++){
			xAtual = (int) jogador.posicaoJogador.getX();
			yAtual = (int) jogador.posicaoJogador.getY();	

			casa = casas.getCasabyId(i > 39 ? i % 40 : i);	

			if (casa.position == 0){
				if (casa.id == 0)
					jogador.alterarPosicaoJogador(xAtual - 100+10, yAtual, 10, 20);
				else jogador.alterarPosicaoJogador(xAtual - 70+10, yAtual, 10, 20);
			}
			else if (casa.position == 1){
				if (casa.id == 10)
					jogador.alterarPosicaoJogador(xAtual, yAtual - 100+20, 10, 20);
				else jogador.alterarPosicaoJogador(xAtual, yAtual - 70+20, 10, 20);
			}
			else if (casa.position == 2){
				if (casa.id == 20)
					jogador.alterarPosicaoJogador(xAtual + 100, yAtual, 10, 20);
				else jogador.alterarPosicaoJogador(xAtual + 70, yAtual, 10, 20);
			}
			else if (casa.position == 3){
				if (casa.id == 30)
					jogador.alterarPosicaoJogador(xAtual, yAtual + 100, 10, 20);
				else jogador.alterarPosicaoJogador(xAtual, yAtual + 70, 10, 20);
			}
		}
	
	}

	public ArrayList<Rectangle> desenharJogadores(){
		ArrayList<Rectangle> posicoes = new ArrayList<>();
		Jogador jogador;

		for (int i = 0; i < this.numJogadores; i++){
			jogador = this.getJogadorById(i);		
			posicoes.add(jogador.obterPosicaoJogador());
		}

		return posicoes;
	}

}
