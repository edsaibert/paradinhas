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
                System.out.println("VOLTE INICIO!");
                jogadores.getJogadorById(jogadorId).setCasaAtual(0);
                jogadores.atualizarCarteira(jogadorId, 200);
                break;
            case 1:
                System.out.println("GANHE UMA TAXA!");
                jogadores.atualizarCarteira(jogadorId, 100);
                break;
            case 2:
                System.out.println("PERCA UMA TAXA!");
                if(jogadores.getJogadorById(jogadorId).getCarteira() >= 100)
                    jogadores.atualizarCarteira(jogadorId, -100);
                else
                    retorno.add(100);
                break;
            case 3:
                System.out.println("VISITE OS PROCESSADOS");
                jogadores.getJogadorById(jogadorId).setCasaAtual(10);
                break;
            case 4:
                System.out.println("PROXIMO 9");
                int idx = -1, i = jogadores.getJogadorById(jogadorId).getCasaAtual()+1;
                while(idx == -1) {
                    if(i == 40)
                        i = 0;
                    if(casas.getCasabyId(i).getTipo() == 9)
                        idx = i;
                    i++;
                }
                jogadores.getJogadorById(jogadorId).setCasaAtual(idx);
                break;
            case 5:
                System.out.println("TOME FALTA");
                jogadores.getJogadorById(jogadorId).setCasaAtual(4);
                if(jogadores.getJogadorById(jogadorId).getCarteira() >= 100)
                    jogadores.atualizarCarteira(jogadorId, -100);
                else
                    retorno.add(100);
                break;
            case 6:
                System.out.println("AULA VAGA!");
                jogadores.getJogadorById(jogadorId).setCasaAtual(20);
                break;
            case 7:
                System.out.println("VOLTE 3");
                if(jogadores.getJogadorById(jogadorId).getCasaAtual() < 3) 
                    jogadores.getJogadorById(jogadorId).setCasaAtual(39);
                
                else 
                    jogadores.getJogadorById(jogadorId).setCasaAtual(jogadores.getJogadorById(jogadorId).getCasaAtual()-3);
                
                break;
            case 8:
                System.out.println("PULE 5");
                    jogadores.getJogadorById(jogadorId).setCasaAtual(jogadores.getJogadorById(jogadorId).getCasaAtual()+5);
                    if(jogadores.getJogadorById(jogadorId).getCasaAtual() >= 40){
                        jogadores.atualizarCarteira(jogadorId, 200);
                        jogadores.getJogadorById(jogadorId).setCasaAtual((jogadores.getJogadorById(jogadorId).getCasaAtual()) % 40);
                    }
                break;
            default:
                System.out.println("FOI PROCESSADO");
                jogadores.getJogadorById(jogadorId).setPreso(true);
                jogadores.getJogadorById(jogadorId).setCasaAtual(10);
                break;
        }

        return retorno;
    }
}
