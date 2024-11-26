package casa;

import java.util.ArrayList;

import jogador.Jogador;

public class CasaController {

    protected ArrayList<Casa> todasCasas = new ArrayList<Casa>();
    protected ArrayList<CasaCompravel> compraveis = new ArrayList<CasaCompravel>();

    public CasaController() {

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
}