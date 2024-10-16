package monopoly;

import java.awt.*;
import javax.swing.*;
//(INCOMPLETO)
//FALTA OS METODOS DE INTERFACE E POLIMENTO DO RESTANTE DOS METODOS

/* PENSO EM IMPLEMENTARMOS UM VETOR DE CASAS NO TABULEIRO, TALVEZ DOIS VETORES, UM DE CASAS
 * COMPRAVEIS E OUTRO DE CASAS NAO COMPRAVEIS. ISSO FAZ COM QUE NAO PRECISAMOS DO ID DE CADA
 * CASA, MAS AINDA PRECISEMOS DO ID DO POSSIVEL DONO DA CASA*/

public class casas {
    
    int precoCompra;
    int precoAluguel;
    String nome;
    int dono = 0;

    public void setCompra(int compra) {
        precoCompra = compra;
    }

    public int getCompra() {
        return precoCompra;
    }

    public void setAluguel(int aluguel) {
        precoAluguel = aluguel;
    }

    public int getAluguel() {
        return precoAluguel;
    }

    public void setNome(String name) {
        nome = name;
    }

    public String getNome() {
        return nome;
    }

    public void setDono(int id) {
        dono = id;
    }

    public int getDono() {
        return dono;
    }

    //CONSTRUTOR
    public casas(int compra, int aluguel, String name) {
        setCompra(compra);
        setAluguel(aluguel);
        setNome(name);
    }
}
