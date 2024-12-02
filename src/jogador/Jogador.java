package jogador;
import java.util.*;
import design.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Jogador {
	public int id;
	protected int casaAtual;
	protected int carteira;
	protected boolean ativo;
	protected boolean preso;
	public String img;
	public Text dinheiro;

	protected HashSet<Integer> casasCompraveis;
	protected HashSet<Integer> casasCompradas;
	
	public Jogador(int id){
		this.id = id;
		this.casaAtual = 0;
		this.carteira = 25000;
		this.ativo = true;
		this.casasCompraveis = new HashSet<>(); 
		this.casasCompradas = new HashSet<>();
		this.img = "application/assets/players/player"+id+".png";
	}

	public int getCasaAtual(){ return this.casaAtual; }

	public String getImg() { return this.img; }

	public void setDinheiro(int x, int y) { this.dinheiro = new Text(x,y,"I$ " + carteira + "   " + this.getCasaAtual()); }

	public int getCarteira(){ return this.carteira;	}
	
	public boolean getPreso() { return this.preso; }

	public void setTexto() { this.dinheiro.setText("I$ " + this.getCarteira() + "   " + this.getCasaAtual()); this.dinheiro.setFont(new Font(28)); }

	public void setPreso(boolean prisao) { this.preso = prisao; }

	public void setCasaAtual(int casa){ this.casaAtual = casa; }

	public void setCarteira(int dinheiro){ this.carteira = dinheiro; }

	public boolean getEstado(){ return this.ativo; }

	public void atualizarEstado(){ this.ativo = !(this.ativo); }
	
	public HashSet<Integer> getCasasCompraveis(){ return this.casasCompraveis; }

	public HashSet<Integer> getCasasCompradas(){ return this.casasCompradas; }

	public void setCasasCompraveis(HashSet<Integer> ht){ this.casasCompraveis = ht; }

	public void setCasasCompradas(HashSet<Integer> ht){	this.casasCompradas = ht; }
}
