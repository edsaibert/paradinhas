package casa;
import java.util.*;
//import carta.*;

public class Casa {
	public int id;
	public String pathImagem;
	protected int tipo;
	protected String nome;
	//protected Carta carta;

	//ID É O MESMO QUE A POSIÇÃO DELA.
	public Casa(int id, String pathImagem, int tipo, String nome){
		this.id = id;
		this.pathImagem = pathImagem;
		this.tipo = tipo;
		this.nome = nome;
		//this.carta = new Carta(...);
	}

	public int getId() { return id; }

	public int getTipo() { return tipo;	}

	public String getImg() { return pathImagem; }

	public String getNome() { return nome; }
}

