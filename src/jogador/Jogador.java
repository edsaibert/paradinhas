package jogador;
import java.util.*;

public class Jogador {
	public int id;
	protected int casaAtual;
	protected int carteira;
	protected boolean ativo;

	protected HashSet<Integer> casasCompraveis;
	protected HashSet<Integer> casasCompradas;
	
	public Jogador(int id){
		this.id = id;
		this.casaAtual = 0;
		this.carteira = 25000;
		this.ativo = true;
		this.casasCompraveis = new HashSet<>(); 
		this.casasCompradas = new HashSet<>();
	}

	public int getCasaAtual(){
		return this.casaAtual;
	}

	public int getCarteira(){
		return this.carteira;
	}

	public void setCasaAtual(int casa){
		this.casaAtual = casa;
	}

	public void setCarteira(int dinheiro){
		this.carteira = dinheiro;
	}

	public boolean getEstado(){
		return this.ativo;
	}

	public void atualizarEstado(){
		this.ativo = !(this.ativo);
	}
	
	public HashSet<Integer> getCasasCompraveis(){
		return this.casasCompraveis;
	}

	public HashSet<Integer> getCasasCompradas(){
		return this.casasCompradas;
	}

	public void setCasasCompraveis(HashSet<Integer> ht){
		this.casasCompraveis = ht;
	}

	public void setCasasCompradas(HashSet<Integer> ht){
		this.casasCompradas = ht;
	}


}
