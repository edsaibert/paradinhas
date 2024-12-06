package jogador;
import java.util.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;



public class Jogador {
	public int id;
	protected int casaAtual;
	protected int carteira;
	protected boolean ativo;
	protected boolean preso;
	public String img;
	public Text dinheiro;
	public Rectangle posicaoJogador;
	public ImageView indicador;

	protected HashSet<Integer> casasCompraveis;
	protected HashSet<Integer> casasCompradas;
	protected HashSet<Integer> casasHipotecadas;
	
	public Jogador(int id){
		this.id = id;
		this.casaAtual = 0;
		this.carteira = 1500;
		this.ativo = true;
		this.casasCompraveis = new HashSet<>(); 
		this.casasCompradas = new HashSet<>();
		this.casasHipotecadas = new HashSet<>();
		this.img = "application/assets/players/player"+id+".png";

		Image image = new Image("application/assets/players/setaE4.png");
		ImageView imageView = new ImageView(image);
		imageView.setVisible(false);
		imageView.setX(250);
		
		this.posicaoJogador = new Rectangle();
		this.posicaoJogador.setWidth(10);
		this.posicaoJogador.setHeight(20);
		this.posicaoJogador.setX(1365 - (id*10));
		this.posicaoJogador.setY(920-20);

		switch (id){
			case 0:
				this.posicaoJogador.setFill(Color.web("#4caf50", 0.75));
				imageView.setY(150);
				break;
			case 1:
				this.posicaoJogador.setFill(Color.web("#ffeb3b", 0.75));
				imageView.setY(300);
				break;
			case 2:
				this.posicaoJogador.setFill(Color.web("#f44336", 0.75));
				imageView.setY(450);
				break;
			case 3:
				this.posicaoJogador.setFill(Color.web("#673ab7", 0.75));
				imageView.setY(600);
				break;
			case 4:
				this.posicaoJogador.setFill(Color.web("#000000", 0.75));
				imageView.setY(750);
				break;
			case 5:
				this.posicaoJogador.setFill(Color.web("#9e9e9e", 0.75));
				imageView.setY(900);
				break;

			}
		this.indicador = imageView;
	}

	public int getCasaAtual(){ return this.casaAtual; }

	public String getImg() { return this.img; }

	public void mudarVisibilidadeIndicador(Boolean visivel){
		this.indicador.setVisible(visivel);
	}

	public ImageView obterIndicador(){
		return this.indicador;
	}

	public void alterarPosicaoJogador(int x, int y, int width, int height){
		this.posicaoJogador.setX(x);
		this.posicaoJogador.setY(y);
		this.posicaoJogador.setWidth(width);
		this.posicaoJogador.setHeight(height);
	}

	public Rectangle obterPosicaoJogador(){
		return this.posicaoJogador;
	}

	public void setDinheiro(int x, int y) { this.dinheiro = new Text(x,y,"I$ " + carteira + " C:" + this.getCasaAtual()); }

	public int getCarteira(){ return this.carteira;	}
	
	public boolean getPreso() { return this.preso; }

	public void setTexto() { this.dinheiro.setText("I$ " + this.getCarteira() + " C:" + this.getCasaAtual()); this.dinheiro.setFont(new Font(28)); }

	public void setPreso(boolean prisao) { this.preso = prisao; }

	public void setCasaAtual(int casa){ this.casaAtual = casa; }

	public void setCarteira(int dinheiro){ this.carteira = dinheiro; }

	public boolean getEstado(){ return this.ativo; }

	public void atualizarEstado(){ this.ativo = !(this.ativo); }
	
	public HashSet<Integer> getCasasCompraveis(){ return this.casasCompraveis; }

	public HashSet<Integer> getCasasCompradas(){ return this.casasCompradas; }

	public HashSet<Integer> getCasasHipotecadas(){ return this.casasHipotecadas; }

	public void setCasasCompraveis(HashSet<Integer> ht){ this.casasCompraveis = ht; }

	public void setCasasCompradas(HashSet<Integer> ht){	this.casasCompradas = ht; }
}
