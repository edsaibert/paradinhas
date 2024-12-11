package jogador;
import java.io.Serializable;
import java.util. *;
import casa.*;
import application.javafxSerializable.*;

public class JogadorController implements Serializable{
	protected ArrayList<Jogador> jogadores;
	
	protected int numJogadores;

	public JogadorController(int numJogadores){
		this.numJogadores = numJogadores;
		this.jogadores = new ArrayList<>();
	}	

	public void resetarJogadores(){
		Jogador jogador;
		for (int i = 0; i < this.numJogadores; i++){
			jogador = this.jogadores.get(i);
			jogador.resetJogador();
		}
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

	public void setIndicadorJogadores(){
		Jogador jogador;
		for (int i = 0; i < this.numJogadores; i++){
			jogador = this.jogadores.get(i);
			jogador.setIndicador();
		}
	}

	public void setPosicaoJogadores(){
		Jogador jogador;
		for (int i = 0; i < this.numJogadores; i++){
			jogador = this.jogadores.get(i);
			jogador.setPosicao();
		}
	}

	public void desenharJogador(int idJogador, int numDados, CasaController casas){
		Jogador jogador = this.jogadores.get(idJogador);
		Casa casa;
		int xAtual; int yAtual;

		for (int i = jogador.casaAtual; i < jogador.casaAtual + numDados; i++){
			xAtual = (int) jogador.posicaoJogador.getX();
			yAtual = (int) jogador.posicaoJogador.getY();	

			casa = casas.getCasabyId(i > 39 ? i % 40 : i);	

			switch (casa.id){
				case 0:
					jogador.alterarPosicaoJogador(xAtual - 100, yAtual, 10, 20);
					break;
				case 10:
					jogador.alterarPosicaoJogador(xAtual, yAtual - 100, 10, 20);
					break;
				case 29:
					jogador.alterarPosicaoJogador(xAtual+100, yAtual, 10, 20);
					break;
				case 39:
						jogador.alterarPosicaoJogador(xAtual, yAtual+100, 10, 20);
					break;
				default:
					if (casa.position == 0) jogador.alterarPosicaoJogador(xAtual - 70, yAtual, 10, 20);
					else if (casa.position == 1) jogador.alterarPosicaoJogador(xAtual, yAtual - 70, 10, 20);
					else if (casa.position == 2) jogador.alterarPosicaoJogador(xAtual + 70, yAtual, 10, 20);
					else if (casa.position == 3) jogador.alterarPosicaoJogador(xAtual, yAtual + 70, 10, 20);
					break;
			}
	}
}

	public void alterarVisibilidade(int idJogador){
		Jogador jogador;
		for (int i = 0; i < this.numJogadores; i++) {
			jogador = this.getJogadorById(i);

			if (i == idJogador)
				jogador.mudarVisibilidadeIndicador(true);	

			else jogador.mudarVisibilidadeIndicador(false);
		}
	}

	public ArrayList<ImageViewSerialize> desenharQuemJogando(){
		Jogador jogador;
		ArrayList<ImageViewSerialize> ImageViewSerialize = new ArrayList<ImageViewSerialize>();

		for (int i = 0; i < this.numJogadores; i++){
			jogador = this.getJogadorById(i);
			ImageViewSerialize.add(jogador.indicador);
		}	

		return ImageViewSerialize;
	}

	public ArrayList<RectangleSerialize> desenharJogadores(){
		ArrayList<RectangleSerialize> posicoes = new ArrayList<>();
		Jogador jogador;

		for (int i = 0; i < this.numJogadores; i++){
			jogador = this.getJogadorById(i);		
			posicoes.add(jogador.obterPosicaoJogador());
		}

		return posicoes;
	}

	public void resetarTextos() {
		Jogador jogador;

		for(int i = 0; i < this.numJogadores; i++) {
			jogador = this.getJogadorById(i);
			jogador.setTexto();
		}
	}

}
