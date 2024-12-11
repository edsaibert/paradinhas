package casa;

import java.io.Serializable;
import java.util.*;
import jogo.Carta;

public class Casa implements Serializable{
	public int id;
	public String pathImagem;
	public String pathSeta;
	protected int tipo;
	public int position;
	protected Carta carta;

	//ID É O MESMO QUE A POSIÇÃO DELA.
	public Casa(int id, String pathImagem, int tipo){
		this.id = id;
		this.pathImagem = pathImagem;
		this.tipo = tipo;

		if (id >= 0 && id <= 9) {
			this.position = 0;
			this.pathSeta = "application/assets/players/setaC1.png";
		}
		if (id >= 10 && id <= 19) {
			this.position = 1;
			this.pathSeta = "application/assets/players/setaD1.png";
		}
		if (id >= 20 && id <= 29) {
			this.position = 2;
			this.pathSeta = "application/assets/players/setaB1.png";
		}
		if (id >= 30 && id <= 39) {
			this.position = 3;
			this.pathSeta = "application/assets/players/setaE1.png";
		}
		
		this.carta = new Carta();
	}

	public int getId() { return id; }

	public int getTipo() { return tipo;	}

	public Carta getCarta() { return carta; }

	public void setImg(String img) { this.pathImagem = img; }

	public String getImg() { return pathImagem; }

	public void setSeta(String seta) { this.pathSeta = seta; }

	public String getSeta() { return pathSeta; }
}

