package casa;

import java.util.ArrayList;

import jogador.Jogador;

public class CasaController {

    protected ArrayList<Casa> todasCasas = new ArrayList<Casa>();
    protected ArrayList<CasaCompravel> compraveis = new ArrayList<CasaCompravel>();

    public CasaController(Tabuleiro t) {
        this.todasCasas = t.getTodasCasas();
        this.compraveis = t.getCompraveis();
    }

    public void Hipoteca (Jogador p) {
        int idx = -1,i = 0;
        while(idx == -1) {
            if(compraveis.get(i).getId() == p.getCasaAtual()) {
                idx = i;
            }
            i++;
        }

        if(compraveis.get(idx).getHipotecado()) 
            if(p.getCarteira() >= (6*(compraveis.get(idx).getValorCompra())/10)) {
                p.setCarteira(p.getCarteira()-(6*(compraveis.get(idx).getValorCompra())/10));
                compraveis.get(idx).atualizarHipotecado();
            }
        
        else {
            p.setCarteira(p.getCarteira()+(compraveis.get(idx).getValorCompra())/2);
            compraveis.get(idx).atualizarHipotecado();
        }
    }

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

    public void Melhoria(Jogador p, int categoria) {
        int idx = -1,i = 0;
        while(idx == -1) {
            if(compraveis.get(i).getId() == p.getCasaAtual()) {
                idx = i;
            }
            i++;
        }
        int diff = compraveis.get(idx).getCategoria() - categoria;
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