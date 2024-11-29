package jogo;

import java.util.ArrayList;

import application.dadoGraphic;
import casa.CasaController;
import casa.Tabuleiro;
import jogador.JogadorController;
import javafx.scene.control.Button;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;

public class Jogo {
    protected JogadorController jogadores;
    protected CasaController casas;
    protected dadoGraphic dado1 = new dadoGraphic();
    protected dadoGraphic dado2 = new dadoGraphic();
    protected int contadorTurno = 0;
    protected int quemJogando = 0;
    protected boolean dadoIgual = false;
    protected boolean comecou = false;
    protected boolean decidiu = false;
    protected Tabuleiro tabuleiro = new Tabuleiro();
    public Button roleDados = new Button("Rolar Dados");
    public Button passeTurno = new Button("Passar Turno");
    protected Button comprar = new Button("Comprar Propriedade");
    protected Button melhorar = new Button("Melhorar Propriedade");
    protected Button hipotecar = new Button("Hipotecar");

    public Jogo(int quantos) {
        jogadores = new JogadorController(quantos);
        jogadores.criarJogadores();
        tabuleiro.iniciaTabuleiro(quantos);
        tabuleiro.limpaValores();
        casas = new CasaController(tabuleiro);
        passeTurno.setDisable(true);
        hipotecar.setDisable(true);
        comprar.setDisable(true);
        roleDados.setDisable(false);
        melhorar.setDisable(true);

        EventHandler<ActionEvent> eventoComprar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int atual = jogadores.getJogadorById(quemJogando).getCasaAtual();
                
            }
        };

        //EVENTO DO BOTAO DE PASSAR O TURNO
        EventHandler<ActionEvent> eventoPassar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //SE PRECISA ATUALIZAR A ORDEM JA DECIDIDA
                if(decidiu) {
                    tabuleiro.limpaOrdem();
                    tabuleiro.setOrdem(tabuleiro.getValores());
                    decidiu = false;
                    //ATUALIZA A ORDEM N-1 VEZES, POIS ELE ATUALIZA A ORDEM FORA DO IF E A PRIMEIRA RODADA PODERIA SER PULADA 
                    for(int i = 0; i < jogadores.getNumJogadores()-1;i++) {
                        tabuleiro.atualizaOrdem();
                    }
                }

                tabuleiro.atualizaOrdem();
                quemJogando = tabuleiro.getFirstOrdem();
                passeTurno.setDisable(true);
                hipotecar.setDisable(true);
                comprar.setDisable(true);
                roleDados.setDisable(false);
                melhorar.setDisable(true);
            }
        };

        //EVENTO DO BOTAO DE ROLAR OS DADOS
        EventHandler<ActionEvent> eventoDado = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {   
                dado1.rolaDado();
                dado2.rolaDado();
                dado1.setaImagem();
                dado2.setaImagem();
                if(dado1.valorDado() == dado2.valorDado())
                    dadoIgual = true;
                else
                    dadoIgual = false;

                //NAO ESTA NA FASE DE DECISAO DE ORDEM DE JOGO
                if(comecou) {
                    System.out.println(tabuleiro.getOrdem());
                    //SE O JOGADOR ATUAL NÃO ESTÁ PRESO
                    if(!jogadores.getJogadorById(quemJogando).getPreso()){
                        
                        System.out.println(quemJogando + ": " +jogadores.getJogadorById(quemJogando).getCasaAtual());
                        System.out.println("VALOR DOS DADOS: "+ dado1.valorDado() + " " + dado2.valorDado());
                        jogadores.atualizarCasaAtual(quemJogando, dado1.valorDado()+dado2.valorDado());
                        System.out.println(quemJogando + ": " +jogadores.getJogadorById(quemJogando).getCasaAtual());
                        int atual = jogadores.getJogadorById(quemJogando).getCasaAtual();
                        //SE A CASA QUE O JOGADOR CHEGOU É COMPRÁVEL
                        if(casas.checaCompravel(atual)) {
                            //SE A CASA NAO TEM DONO
                            if(tabuleiro.getCasaCIndex(atual).getDono() == -1) {
                                if(jogadores.getJogadorById(quemJogando).getCarteira() >= tabuleiro.getCasaCIndex(atual).getValorCompra())
                                    comprar.setDisable(false);
                                else
                                    comprar.setDisable(true);
                                hipotecar.setDisable(true);
                                melhorar.setDisable(true);
                            
                            }
                            //SE A CASA TEM DONO
                            else {
                                comprar.setDisable(true);
                                //SE O DONO É O JOGADOR DA RODADA
                                if(tabuleiro.getCasaCIndex(atual).getDono() == quemJogando) {
                                    hipotecar.setDisable(true);
                                    //SE A CASA PODE SER MELHORADA
                                    if((tabuleiro.getCasaCIndex(atual).getCategoria() > 0 || tabuleiro.getCasaCIndex(atual).getCategoria() < 6)) {
                                        //SE O JOGADOR POSSUI DINHEIRO PARA MELHORAR
                                        if(jogadores.getJogadorById(quemJogando).getCarteira() >= 2*tabuleiro.getCasaCIndex(atual).getValorAluguel()) 
                                            melhorar.setDisable(false);
                                        else
                                            melhorar.setDisable(true);
                                    }
                                }
                                //SE O DONO É OUTRO JOGADOR
                                else {
                                    melhorar.setDisable(true);
                                    //SE O JGOADOR NAO POSSUE DINHEIRO PARA PAGAR O ALUGUEL (AINDA INCOMPLETO, PRECISO PENSAR NA LÓGICA)
                                    if(jogadores.getJogadorById(quemJogando).getCarteira() < tabuleiro.getCasaCIndex(atual).getValorAluguel()) {
                                        hipotecar.setDisable(false);
                                    }
                                    //SE O JOGADOR PODE PAGAR O ALUGUEL
                                    else {
                                        hipotecar.setDisable(true);
                                        jogadores.atualizarCarteira(quemJogando, -tabuleiro.getCasaCIndex(atual).getValorAluguel());
                                        jogadores.atualizarCarteira(tabuleiro.getCasaCIndex(atual).getDono(), tabuleiro.getCasaCIndex(atual).getValorAluguel());
                                    }
                                }
                            }
                        }
                    }
                    //SE O JOGADOR ATUAL ESTIVER PRESO
                    else {
                        comprar.setDisable(true);
                        hipotecar.setDisable(true);
                        melhorar.setDisable(true);
                    }
                    //SE O JOGADOR TEVE UMA ROLAGEM DE 2 DADOS IGUAIS (REPETE A RODADA)
                    if(dadoIgual) {
                        jogadores.getJogadorById(quemJogando).setPreso(false);
                        roleDados.setDisable(false);
                        passeTurno.setDisable(true);
                    }
                    else {
                        roleDados.setDisable(true);
                        passeTurno.setDisable(false);
                    }
                }
                //SE O JOGO AINDA ESTA DECIDINDO A ORDEM DE JOGADORES
                else {
                    tabuleiro.novoValor(dado1.valorDado()+dado2.valorDado());
                    hipotecar.setDisable(true);
                    comprar.setDisable(true);
                    melhorar.setDisable(true);
                    roleDados.setDisable(true);
                    passeTurno.setDisable(false);
                    if(quemJogando == jogadores.getNumJogadores()-1) {
                        comecou = true;
                        decidiu = true;
                    }
                }
            }
        };

        roleDados.setOnAction(eventoDado);
        passeTurno.setOnAction(eventoPassar);
        passeTurno.setTranslateY(70);
    }
}
