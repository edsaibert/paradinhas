package casa;

import java.util. *;

import jogador.Jogador;

public class CasaController {

    protected ArrayList<Casa> todasCasas = new ArrayList<Casa>();
    protected ArrayList<CasaCompravel> compraveis = new ArrayList<CasaCompravel>();

    public CasaController(Tabuleiro t) {
        this.todasCasas = t.getTodasCasas();
        this.compraveis = t.getCompraveis();
    }

	public boolean temMonopolio(int tipo, Jogador player) {
		boolean tem = false;
		int cont = 0;
		for(int i = 0;i < 40;i++) {
			if(player.getCasasCompradas().contains(i) && todasCasas.get(i).getTipo() == tipo) {
                cont++;
            }
		}
        if(tipo == 1 || tipo == 8) {
            if(cont == 2)
                tem = true;
        }
        else  {
            if(cont == 3)
                tem = true;
        }

		return tem;
	}

    public Casa getCasabyId(int index) { return todasCasas.get(index); }

    public CasaCompravel getCasaCompravelbyId(int index) {
        int idx = -1,i = 0;
        while(idx == -1) {
            if(compraveis.get(i).getId() == todasCasas.get(index).getId()) {
                idx = i;
            }
            i++;
        }

        return compraveis.get(idx);
     }

    public boolean checaCompravel(int index) {
        boolean compravel = false;
        int i = 0;
        while(compravel == false && i < compraveis.size()) {
            if(compraveis.get(i).getId() == index)
                compravel = true;
            i++;
        }

        return compravel;
    }

    public void Hipoteca (Jogador p, int idCasa) {
        p.setCarteira(p.getCarteira()+(compraveis.get(idCasa).getValorCompra())/2);
    }

    public void HipotecaRemove (Jogador p, int idCasa) {
        p.setCarteira(p.getCarteira()-(6*(compraveis.get(idCasa).getValorCompra())/10));
    }

    //QUERO MELHORAR A CASA EM 1 NIVEL
    public void Melhoria(Jogador p) {
        int idx = -1,i = 0;
        while(idx == -1) {
            if(compraveis.get(i).getId() == p.getCasaAtual()) {
                idx = i;
            }
            i++;
        }

        compraveis.get(idx).setCategoria(compraveis.get(idx).getCategoria()+1);
        compraveis.get(idx).setValorAluguel(compraveis.get(idx).getValorAluguel()*2);
    }

    //SE, AO INVES DE MELHORAR EM 1 NIVEL, EU QUERO SETAR UMA CATEGORIA ESPECIFICA
    public void Melhoria(int casaId, int categoria) {
        int idx = -1,i = 0;
        while(idx == -1) {
            if(compraveis.get(i).getId() == casaId) {
                idx = i;
            }
            i++;
        }
        int diff = categoria - compraveis.get(idx).getCategoria();
        System.out.println(diff);
        compraveis.get(idx).setCategoria(categoria);
        if(diff >= 0) 
            for(i = 0;i < diff;i++) 
                compraveis.get(idx).setValorAluguel(compraveis.get(idx).getValorAluguel()*2);
        
        else {
            diff *= -1;
            for(i = 0;i < diff;i++) 
                compraveis.get(idx).setValorAluguel(compraveis.get(idx).getValorAluguel()/2);
        }
    }
}