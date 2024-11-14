import java.util.*;

package Jogador;

public class Jogador {
	protected int id;
	protected int casaAtual;
	protected int carteira;
	protected boolean ativo;

	ArrayList<int> casasCompraveis;
	ArrayList<int> casasCompradas;
	
	public Joagdor(int id){
		this.id = id;
		this.casaAtual = 0;
		this.carteira = 25000;
		this.ativo = true;
		this.casasCompraveis = new HashSet<int>(); 
		this.casasCompradas = new HashSet<int>();
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
	
	public HashSet<int> getCasasCompraveis(){
		return this.casasCompraveis;
	}

	public HashSet<int> getCasasCompradas(){
		return this.casasCompradas;
	}

	public void setCasasCompraveis(HashSet<int> ht){
		this.casasCompraveis = ht;
	}

	public void setCasasCompradas(HashSet<int> ht){
		this.casasCompradas = ht;
	}


}
