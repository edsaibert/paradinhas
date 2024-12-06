package jogo;

import java.util.Random;
import casa.CasaController;
import jogador.JogadorController;
import java.util.ArrayList;

public class Carta {
    
    Random rnd = new Random();
    int valor = -1;

    public ArrayList<Integer> acaoCarta(JogadorController jogadores, CasaController casas, int jogadorId) {
        valor = rnd.nextInt(10);
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        retorno.add(valor);
        switch(valor) {
            case 0:
                int quantos = 40-jogadores.getJogadorById(jogadorId).getCasaAtual();
                jogadores.desenharJogador(jogadorId, quantos, casas);
                jogadores.atualizarCasaAtual(jogadorId, quantos);
                break;
            case 1:
                jogadores.atualizarCarteira(jogadorId, 100);
                break;
            case 2:
                if(jogadores.getJogadorById(jogadorId).getCarteira() >= 100)
                    jogadores.atualizarCarteira(jogadorId, -100);
                else
                    retorno.add(100);
                break;
            case 3:
                int caminho = 0,i = jogadores.getJogadorById(jogadorId).getCasaAtual();
                if(i > 10)
                    jogadores.atualizarCarteira(jogadorId, -200);
                while(i != 10) {
                    caminho++;
                    i++;
                    if(i == 40)
                        i = 0;
                }
                jogadores.desenharJogador(jogadorId, caminho, casas);
                jogadores.atualizarCasaAtual(jogadorId, caminho);
                break;
            case 4:
                int idx = 0;
                i = jogadores.getJogadorById(jogadorId).getCasaAtual();
                while(casas.getCasabyId(i).getTipo() != 9) {
                    idx++;
                    i++;
                    if(i == 40)
                        i = 0;
                }
                jogadores.desenharJogador(jogadorId, idx, casas);
                jogadores.atualizarCasaAtual(jogadorId, idx);
                break;
            case 5:
                int falta = 0;
                i = jogadores.getJogadorById(jogadorId).getCasaAtual();
                while(i != 4) {
                    falta++;
                    i++;
                    if(i == 40)
                        i = 0;
                }
                jogadores.desenharJogador(jogadorId, falta, casas);
                jogadores.atualizarCasaAtual(jogadorId, falta);
                if(jogadores.getJogadorById(jogadorId).getCarteira() >= 100)
                    jogadores.atualizarCarteira(jogadorId, -100);
                else
                    retorno.add(100);
                break;
            case 6:
                int indic = 0;
                i = jogadores.getJogadorById(jogadorId).getCasaAtual();
                while(i != 20) {
                    indic++;
                    i++;
                    if(i == 40)
                        i = 0;
                }
                jogadores.desenharJogador(jogadorId, indic, casas);
                jogadores.atualizarCasaAtual(jogadorId, indic);
                break;
            case 7:
                if(jogadores.getJogadorById(jogadorId).getCasaAtual() >= 3)
                    jogadores.atualizarCarteira(jogadorId, -200);
                jogadores.desenharJogador(jogadorId, 37, casas);
                jogadores.atualizarCasaAtual(jogadorId, 37);
                break;
            case 8:
                jogadores.desenharJogador(jogadorId, 5, casas);
                jogadores.atualizarCasaAtual(jogadorId, 5);
                break;
            default:
                jogadores.getJogadorById(jogadorId).setPreso(true);
                int preso = 0;
                i = jogadores.getJogadorById(jogadorId).getCasaAtual();
                if(i > 10)
                    jogadores.atualizarCarteira(jogadorId, -200);
                while(i != 10) {
                    if(i == 40)
                        i = 0;
                    preso++;
                    i++;
                }
                jogadores.desenharJogador(jogadorId, preso, casas);
                jogadores.atualizarCasaAtual(jogadorId, preso);
                break;
        }

        return retorno;
    }
}
