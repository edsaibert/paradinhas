package casa;

import java.io.Serializable;

public class CasaCompravel extends Casa implements Serializable{
	protected int valorAluguel;
	protected int valorCompra;
	protected int idDono;
	protected boolean pago;
	protected boolean hipotecado;
	protected int categoria;	

	public CasaCompravel(int id, String pathImagem, int tipo, int valorAluguel, int valorCompra, int categoria){
		super(id, pathImagem, tipo);
		this.valorAluguel = valorAluguel;
		this.valorCompra = valorCompra;
		this.idDono = -1;
		this.pago = false;
		this.hipotecado = false;
		this.categoria = categoria;
	}

	public void setValorAluguel(int valorAluguel){ this.valorAluguel = valorAluguel; }

	public void setValorCompra(int valorCompra){ this.valorCompra = valorCompra; }
	
	public int getValorCompra() { return this.valorCompra; }

	public int getValorAluguel() { return this.valorAluguel; }

	public void setDono(int idDono) { this.idDono = idDono; }

	public int getDono() { return idDono; }

	public boolean getPago() { return this.pago; }

	public void atualizarPago() { this.pago = !this.pago; } 

	public boolean getHipotecado() { return this.hipotecado; }

	public void atualizarHipotecado() { this.hipotecado = !this.hipotecado; }

	public void setHipotecado(boolean hip) { this.hipotecado = hip; }

	public int getCategoria() { return categoria; }

	public void setCategoria(int novaCat) { this.categoria = novaCat; }
}
