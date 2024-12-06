package casa;

import java.util.*;
import jogo.Carta;

public class Casa {
	public int id;
	public String pathImagem;
	public String pathSeta;
	protected int tipo;
	protected String nome;
	public int position;
	protected Carta carta;

	//ID É O MESMO QUE A POSIÇÃO DELA.
	public Casa(int id, String pathImagem, int tipo, String nome){
		this.id = id;
		this.pathImagem = pathImagem;
		this.tipo = tipo;
		this.nome = nome;

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

	public void setSeta(String seta) { 
		System.out.println(pathSeta);
		this.pathSeta = seta; 
		System.out.println(pathSeta);
	}

	public String getSeta() { return pathSeta; }

	public String getNome() { return nome; }
}

