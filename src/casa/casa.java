package casa;
import java.util.*;
//import carta.*;

public class Casa {
	public int id;
	public String pathImagem;

	protected int tipo;
	protected int posicao;
	protected String nome;
	//protected Carta carta;

	public Casa(int id, String pathImagem, int tipo, int posicao, String nome){
		this.id = id;
		this.pathImagem = pathImagem;
		this.tipo = tipo;
		this.posicao = posicao;
		this.nome = nome;
		//this.carta = new Carta(...);
	}

}

