package casa;

import java.util.*;
import jogo.Carta;

public class Casa {
	public int id;
	public String pathImagem;
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

		if (id >= 0 && id <= 9)
			this.position = 0;
		if (id >= 10 && id <= 19)
			this.position = 1;
		if (id >= 20 && id <= 29)
			this.position = 2;
		if (id >= 30 && id <= 39)
			this.position = 3;
		
		this.carta = new Carta();
	}

	public int getId() { return id; }

	public int getTipo() { return tipo;	}

	public Carta getCarta() { return carta; }

	public void setImg(String img) { this.pathImagem = img; }

	public String getImg() { return pathImagem; }

	public String getNome() { return nome; }
}

