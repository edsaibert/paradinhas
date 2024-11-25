package casa;

import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Tabuleiro {

    protected ArrayList<ImageView> casasImg = new ArrayList<ImageView>();
    protected ArrayList<Casa> todasCasas = new ArrayList<Casa>();
    protected ArrayList<Casa> naoCompraveis = new ArrayList<Casa>();
    protected int[] ordem;

    public ArrayList<Casa> getNaoCompraveis() { return naoCompraveis; }

    public ArrayList<Casa> getTodasCasas() { return todasCasas; }

    public ArrayList<ImageView> getTodasImg() { return casasImg; }

    public Casa getCasaIndex(int index) { return todasCasas.get(index); }  

    public Image getCasaImg(int index) { return new Image(todasCasas.get(index).getImg()); }


    public void iniciaTabuleiro() {   
        iniciaCasas();
        graficoCasas(900,900);
    }

    public void setOrdem(int numeros[], int qual) {
        
    }

    public void atualizaOrdem() {
        int temp = this.ordem[0];
        for(int i = 0;i < 5;i++) {
            this.ordem[i] = this.ordem[i+1];
        }
        this.ordem[5] = temp;
    }

    /* VALORES DE SHIFT DO INI COM TODA CERTEZA VÃO MUDAR QUANDO
     * TIVERMOS TODAS AS IMAGENS DE TODAS AS CASAS, POR ENQUANTO É PLACEHOLDER
     * (TESTEI NA BRANCH "DADO" E FUNCIONOU, ENTAO A LÓGICA TA CERTA)
    */
    public void graficoCasas(int xIni, int yIni) {    
        for(int i = 0;i < 40;i++) {
            if(i <= 10) 
                xIni -= 70;
            else if (i > 10 && i <= 20) 
                yIni -= 100;
            else if (i > 20 && i <= 30) 
                xIni += 70;
            else 
                yIni += 100;


            casasImg.add(new ImageView(getCasaImg(i)));
            casasImg.get(i).setX(xIni);
            casasImg.get(i).setY(yIni);
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
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 3:
                    t = 1;
                    pC = 60;
                    pA = 4;
                    break;
                case 4:
                    t = 0;
                    pC = 0;
                    pA = 200;
                    break;
                case 5:
                    t = 0;
                    pC = 10;
                    pA = 10;
                    break;
                case 6:
                    t = 2;
                    pC = 100;
                    pA = 6;
                    break;
                case 7:
                    t = 0;
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
                    t = 0;
                    pC = 0;
                    pA = 0;
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
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 16:
                    t = 4;
                    pC = 180;
                    pA = 14;
                    break;
                case 17:
                    t = 0;
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
                    t = 0;
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
                    t = 0;
                    pC = 0;
                    pA = 0;
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
                    t = 0;
                    pC = 10;
                    pA = 10;
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
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 34:
                    t = 7;
                    pC = 320;
                    pA = 28;
                    break;
                case 35:
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 36:
                    t = 0;
                    pC = 0;
                    pA = 0;
                    break;
                case 37:
                    t = 8;
                    pC = 350;
                    pA = 35;
                    break;
                case 38:
                    t = 0;
                    pC = 0;
                    pA = 100;
                    break;
                default:
                    t = 8;
                    pC = 400;
                    pA = 50;
                    break;
            }

            if (t >=1 && t <= 8) {
                todasCasas.add(new CasaCompravel(i,"STRING PRA IMAGEM",t,"JONAS",pA,pC,0));
            }
            else {
                todasCasas.add(new Casa(i,"STRING PRA IMAGEM",t,"JONAS"));
            }
        }
    }
}
