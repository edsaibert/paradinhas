package casa;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Tabuleiro {

    protected ArrayList<ImageView> casasImg = new ArrayList<ImageView>();
    protected ArrayList<Casa> todasCasas = new ArrayList<Casa>();
    protected ArrayList<CasaCompravel> compraveis = new ArrayList<CasaCompravel>();
    protected ArrayList<Casa> naoCompraveis = new ArrayList<Casa>();
    protected ArrayList<Integer> ordem = new ArrayList<Integer>();
    protected ArrayList<Integer> numDados = new ArrayList<Integer>();
    public ArrayList<ImageView> setasCasas = new ArrayList<ImageView>();
    
    public ArrayList<CasaCompravel> getCompraveis() { return compraveis; }

    public ArrayList<Casa> getNaoCompraveis() { return naoCompraveis; }

    public ArrayList<Casa> getTodasCasas() { return todasCasas; }

    public ImageView getImg(int index) { return casasImg.get(index); }

    public ImageView getSeta(int index) { return setasCasas.get(index); }

    public ArrayList<ImageView> getTodasImg() { return casasImg; }

    public ArrayList<ImageView> getTodasSetas() { return setasCasas; }

    public Casa getCasaIndex(int index) { return todasCasas.get(index); }  
    
    public CasaCompravel getCasaCIndex(int index) { 
        int idx = -1, i = 0;
        while(idx == -1) {
            if(compraveis.get(i).getId() == index)
                idx = i;
                i++;
        } 
        return compraveis.get(idx);
    }

    public Image getCasaImg(int index) { return new Image(todasCasas.get(index).getImg()); }

    public Image getSetaImg(int index) { return new Image(todasCasas.get(index).getSeta());}

    public void novoValor(int valor) { numDados.add(valor); }

    public void limpaValores() { numDados.clear(); }

    public void limpaOrdem() { ordem.clear(); }

    public ArrayList<Integer> getValores() { return numDados; }

    public void iniciaTabuleiro(int jogadores) { 
        iniciaCasas();
        graficoCasas(1345,850);
        for(int i = 0;i < jogadores;i++) 
            numDados.add(i);
        setOrdem(numDados);
        Collections.reverse(ordem);
    }

    public int getFirstOrdem() { return this.ordem.get(0); }

    public ArrayList<Integer> getOrdem() { return this.ordem; }

    public void removeDaOrdem(int idPlayer) {
        ordem.remove(Integer.valueOf(idPlayer));
    }

    public void setOrdem(ArrayList<Integer> numeros) {
        limpaOrdem();

        int maior = 0;

        for(int j = 0;j < numeros.size(); j++) {
            int k = 0;
            while(this.ordem.contains(k)) {
                k++;
            }
            maior = k;
            for(int i = 0; i < numeros.size();i++) {
                if(!this.ordem.contains(i) && numeros.get(i) > numeros.get(maior))
                    maior = i;
            }
            this.ordem.add(maior);
        }
    }

    public void atualizaOrdem() {
        int a = this.ordem.remove(0);
        this.ordem.add(a);
    }

    /* VALORES DE SHIFT DO INI COM TODA CERTEZA VÃO MUDAR QUANDO
     * TIVERMOS TODAS AS IMAGENS DE TODAS AS CASAS, POR ENQUANTO É PLACEHOLDER
     * (TESTEI NA BRANCH "DADO" E FUNCIONOU, ENTAO A LÓGICA TA CERTA)
     * 70x100
    */
    public void graficoCasas(int xIni, int yIni) {
        int xSeta = xIni+20, ySeta = yIni+110;    
        for(int i = 0;i < 40;i++) {
            if(i < 10) {
                xIni -= 70;
                xSeta -=70;
            }
            else if(i == 10){
                xIni -= 100;
                xSeta -= 170;
                ySeta -= 100;
            }
            else if (i > 10 && i < 20) {
                yIni -= 70;
                ySeta -= 70;
            }
            else if(i == 20) {
                yIni -= 100;
                ySeta -= 160;
                xSeta += 100;
            }
            else if(i == 21) {
                xIni += 100;
                xSeta += 80;
            }
            else if (i > 21 && i < 30) {
                xIni += 70;
                xSeta += 70;
            }
            else if(i == 30) {
                xIni += 70;
                xSeta += 150;
                ySeta += 80;
            }
            else if(i == 31) {
                yIni += 100;
                ySeta += 100;
            }
            else {
                yIni += 70;
                ySeta += 70;
            }
            

            casasImg.add(new ImageView(getCasaImg(i)));
            casasImg.get(i).setX(xIni);
            casasImg.get(i).setY(yIni);
            if(i <= 10) {
                setasCasas.add(new ImageView(getSetaImg(i)));
            }
            else if(i > 10 && i <= 20) {
                setasCasas.add(new ImageView(getSetaImg(i)));
            }
            else if(i > 20 && i <= 30) {
                setasCasas.add(new ImageView(getSetaImg(i)));
            }
            else {
                setasCasas.add(new ImageView(getSetaImg(i)));
            }
            setasCasas.get(i).setX(xSeta);
            setasCasas.get(i).setY(ySeta);
            setasCasas.get(i).setVisible(false);
        }
    }

    //TODOS OS "t = 0" DO SWITCH ESTÃO SUJEITOS A MUDANÇA
    public void iniciaCasas() { 
        int t, pC, pA;
        for(int i=0;i < 40;i++) {
            switch(i) {
                case 0:
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 1:
                    t = 1;
                    pC = 60;
                    pA = 2;
                    break;
                case 2:
                    t = 11;
                    pC = 0;
                    pA = 0;
                    break;
                case 3:
                    t = 1;
                    pC = 60;
                    pA = 4;
                    break;
                case 4:
                    t = 10;
                    pC = 0;
                    pA = 200;
                    break;
                case 5:
                    t = 9;
                    pC = 200;
                    pA = 5;
                    break;
                case 6:
                    t = 2;
                    pC = 100;
                    pA = 6;
                    break;
                case 7:
                    t = 11;
                    pC = 0;
                    pA = 0;
                    break;
                case 8:
                    t = 2;
                    pC = 100;
                    pA = 6;
                    break;
                case 9:
                    t = 2;
                    pC = 120;
                    pA = 8;
                    break;
                case 10:
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 11:
                    t = 3;
                    pC = 140;
                    pA = 10;
                    break;
                case 12:
                    t = 9;
                    pC = 200;
                    pA = 5;
                    break;
                case 13:
                    t = 3;
                    pC = 140;
                    pA = 10;
                    break;
                case 14:
                    t = 3;
                    pC = 160;
                    pA = 12;
                    break;
                case 15:
                    t = 9;
                    pC = 200;
                    pA = 5;
                    break;
                case 16:
                    t = 4;
                    pC = 180;
                    pA = 14;
                    break;
                case 17:
                    t = 11;
                    pC = 0;
                    pA = 0;
                    break;
                case 18:
                    t = 4;
                    pC = 180;
                    pA = 14;
                    break;
                case 19:
                    t = 4;
                    pC = 200;
                    pA = 16;
                    break;
                case 20:
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 21:
                    t = 5;
                    pC = 220;
                    pA = 18;
                    break;
                case 22:
                    t = 11;
                    pC = 0;
                    pA = 0;
                    break;
                case 23:
                    t = 5;
                    pC = 220;
                    pA = 18;
                    break;
                case 24:
                    t = 5;
                    pC = 240;
                    pA = 20;
                    break;
                case 25:
                    t = 9;
                    pC = 200;
                    pA = 5;
                    break;
                case 26:
                    t = 6;
                    pC = 260;
                    pA = 22;
                    break;
                case 27:
                    t = 6;
                    pC = 260;
                    pA = 22;
                    break;
                case 28:
                    t = 9;
                    pC = 200;
                    pA = 5;
                    break;
                case 29:
                    t = 6;
                    pC = 280;
                    pA = 24;
                    break;
                case 30:
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 31:
                    t = 7;
                    pC = 300;
                    pA = 26;
                    break;
                case 32:
                    t = 7;
                    pC = 300;
                    pA = 26;
                    break;
                case 33:
                    t = 11;
                    pC = 0;
                    pA = 0;
                    break;
                case 34:
                    t = 7;
                    pC = 320;
                    pA = 28;
                    break;
                case 35:
                    t = 9;
                    pC = 200;
                    pA = 5;
                    break;
                case 36:
                    t = 11;
                    pC = 0;
                    pA = 0;
                    break;
                case 37:
                    t = 8;
                    pC = 350;
                    pA = 35;
                    break;
                case 38:
                    t = 10;
                    pC = 0;
                    pA = 200;
                    break;
                default:
                    t = 8;
                    pC = 400;
                    pA = 50;
                    break;
            }
            if (t >=1 && t <= 9) {
                todasCasas.add(new CasaCompravel(i,"application/assets/casas/casa"+i+".png",t,"JONAS",pA,pC,0));
                compraveis.add(new CasaCompravel(i,"application/assets/casas/casa"+i+".png",t,"JONAS",pA,pC,0));
            }
            else {
                todasCasas.add(new Casa(i,"application/assets/casas/casa"+i+".png",t,"JONAS"));
                naoCompraveis.add(new Casa(i,"application/assets/casas/casa"+i+".png",t,"JONAS"));
            }
        }
    }
}
