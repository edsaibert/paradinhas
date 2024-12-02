package jogo;

import java.util.ArrayList;

import application.dadoGraphic;
import casa.CasaController;
import casa.Tabuleiro;
import jogador.JogadorController;
import javafx.scene.control.Button;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.image.Image;

public class Jogo {
    public JogadorController jogadores;
    protected CasaController casas;
    protected dadoGraphic dado1 = new dadoGraphic();
    protected dadoGraphic dado2 = new dadoGraphic();
    public ArrayList<ImageView> dadosImg = new ArrayList<ImageView>();
    public ArrayList<ImageView> playersFundo = new ArrayList<ImageView>();
    protected int contadorTurno = 0;
    protected int quemJogando = 0;
    protected boolean dadoIgual = false;
    protected boolean comecou = false;
    protected boolean decidiu = false;
    protected Tabuleiro tabuleiro = new Tabuleiro();
    public Button roleDados = new Button("Rolar Dados");
    public Button passeTurno = new Button("Passar Turno");
    public Button comprar = new Button("Comprar Propriedade");
    public Button melhorar = new Button("Melhorar Propriedade");
    public Button hipotecar = new Button("Hipotecar");

    public Jogo(int quantos) {
        dadosImg.add(new ImageView(dado1.getImg()));
        dadosImg.add(new ImageView(dado2.getImg()));
        dadosImg.get(0).setX(1000);
        dadosImg.get(0).setY(800);
        dadosImg.get(1).setX(1200);
        dadosImg.get(1).setY(800);
        jogadores = new JogadorController(quantos);
        jogadores.criarJogadores();
        for(int i = 0; i < quantos;i++) {
            playersFundo.add(new ImageView(new Image(jogadores.getJogadorById(i).getImg())));
            switch(i) {
                case 0:
                    playersFundo.get(i).setX(0);
                    playersFundo.get(i).setY(100);
                    jogadores.getJogadorById(i).setDinheiro(10,180);
                    jogadores.getJogadorById(i).setTexto();
                    break;
                case 1:
                    playersFundo.get(i).setX(0);
                    playersFundo.get(i).setY(250);
                    jogadores.getJogadorById(i).setDinheiro(10,330);
                    jogadores.getJogadorById(i).setTexto();
                    break;
                case 2:
                    playersFundo.get(i).setX(0);
                    playersFundo.get(i).setY(400);
                    jogadores.getJogadorById(i).setDinheiro(10,480);
                    jogadores.getJogadorById(i).setTexto();
                    break;
                case 3:
                    playersFundo.get(i).setX(0);
                    playersFundo.get(i).setY(550);
                    jogadores.getJogadorById(i).setDinheiro(10,630);
                    jogadores.getJogadorById(i).setTexto();
                    break;
                case 4:
                    playersFundo.get(i).setX(0);
                    playersFundo.get(i).setY(700);
                    jogadores.getJogadorById(i).setDinheiro(10,780);
                    jogadores.getJogadorById(i).setTexto();
                    break;
                case 5:
                    playersFundo.get(i).setX(0);
                    playersFundo.get(i).setY(850);
                    jogadores.getJogadorById(i).setDinheiro(10,930);
                    jogadores.getJogadorById(i).setTexto();
                    break;
            }
        }
        tabuleiro.iniciaTabuleiro(quantos);
        tabuleiro.limpaValores();
        casas = new CasaController(tabuleiro);
        passeTurno.setDisable(true);
        hipotecar.setDisable(true);
        comprar.setDisable(true);
        roleDados.setDisable(false);
        melhorar.setDisable(true);


        EventHandler<ActionEvent> eventoMelhorar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int atual = jogadores.getJogadorById(quemJogando).getCasaAtual();
                casas.Melhoria(jogadores.getJogadorById(quemJogando));
                jogadores.getJogadorById(quemJogando).setCarteira(jogadores.getJogadorById(quemJogando).getCarteira()-50*(1+(int)Math.floor(atual/10)));
                hipotecar.setDisable(true);
                comprar.setDisable(true);
                melhorar.setDisable(true);

                for(int i = 0; i < jogadores.getNumJogadores();i++) 
                    jogadores.getJogadorById(i).setTexto();
            }
        };

        EventHandler<ActionEvent> eventoHipotecar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("EVENTO DE HIPOTECAR CASA");

                for(int i = 0; i < jogadores.getNumJogadores();i++) 
                    jogadores.getJogadorById(i).setTexto();
            }
        };

        EventHandler<ActionEvent> eventoComprar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int atual = jogadores.getJogadorById(quemJogando).getCasaAtual();
                jogadores.comprarCasa(quemJogando, atual);
                jogadores.getJogadorById(quemJogando).setCarteira(jogadores.getJogadorById(quemJogando).getCarteira()-tabuleiro.getCasaCIndex(atual).getValorCompra());
                System.out.println(quemJogando + ": " +jogadores.getJogadorById(quemJogando).getCasaAtual() + " " +jogadores.getJogadorById(quemJogando).getCarteira());
                if(true /* CODIGO PRA CHECAR MONOPOLIO*/ && jogadores.getJogadorById(quemJogando).getCarteira() >= 50*(1+Math.floor(atual/10)))
                    melhorar.setDisable(true);
                else
                    melhorar.setDisable(false);

                tabuleiro.getCasaCIndex(atual).setDono(quemJogando);
                hipotecar.setDisable(true);
                comprar.setDisable(true);
                for(int i = 0; i < jogadores.getNumJogadores();i++) 
                    jogadores.getJogadorById(i).setTexto();
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
                for(int i = 0; i < jogadores.getNumJogadores();i++) 
                    jogadores.getJogadorById(i).setTexto();
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
                dadosImg.get(0).setImage(dado1.getImg());
                dadosImg.get(1).setImage(dado2.getImg());
                if(dado1.valorDado() == dado2.valorDado())
                    dadoIgual = true;
                else
                    dadoIgual = false;

                //NAO ESTA NA FASE DE DECISAO DE ORDEM DE JOGO
                if(comecou) {
                    System.out.println(tabuleiro.getOrdem());
                    //SE O JOGADOR ATUAL NÃO ESTÁ PRESO
                    if(!jogadores.getJogadorById(quemJogando).getPreso()){
                        jogadores.atualizarCasaAtual(quemJogando, dado1.valorDado()+dado2.valorDado());
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
                        //SE A CASA NAO É COMPRÁVEL (AINDA RESTA MUITA COISA PRA FAZER AQUI, FAREI DEPOIS)
                        else {

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
                        //SOLTA ELE DA PRISAO
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
                for(int i = 0; i < jogadores.getNumJogadores();i++) 
                    jogadores.getJogadorById(i).setTexto();
            }
        };

        roleDados.setOnAction(eventoDado);
        passeTurno.setOnAction(eventoPassar);
        comprar.setOnAction(eventoComprar);
        melhorar.setOnAction(eventoMelhorar);
        hipotecar.setOnAction(eventoHipotecar);
        roleDados.setTranslateY(0);
        passeTurno.setTranslateY(60);
        comprar.setTranslateY(120);
        melhorar.setTranslateY(180);
        hipotecar.setTranslateY(240);
        roleDados.setTranslateX(1000);
        passeTurno.setTranslateX(1000);
        comprar.setTranslateX(1000);
        melhorar.setTranslateX(1000);
        hipotecar.setTranslateX(1000);
    }
}
