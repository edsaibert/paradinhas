package jogo;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import application.dadoGraphic;
import casa.CasaController;
import casa.Tabuleiro;
import jogador.JogadorController;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer; 

import design.GameButton;

public class Jogo {
    public JogadorController jogadores;
    protected CasaController casas;
    protected dadoGraphic dado1 = new dadoGraphic();
    protected dadoGraphic dado2 = new dadoGraphic();
    public ArrayList<ImageView> dadosImg = new ArrayList<ImageView>();
    public ArrayList<ImageView> playersFundo = new ArrayList<ImageView>();
    protected int contadorTurno = 0;
    public int quemJogando = 0;
    protected boolean dadoIgual = false;
    protected boolean comecou = false;
    protected boolean decidiu = false;
    public Tabuleiro tabuleiro = new Tabuleiro();
    public Text ocorrendo = new Text("Decidindo início de jogo!");

    int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();
    public GameButton roleDados = new GameButton("Rolar Dados", screenWidth - 500, 100);
    public GameButton passeTurno = new GameButton("Passar Turno", screenWidth - 500, 150);
    public GameButton comprar = new GameButton("Comprar Propriedade", screenWidth - 500, 200);
    public GameButton melhorar = new GameButton("Melhorar Propriedade", screenWidth - 500, 250);
    public GameButton hipotecar = new GameButton("Hipotecar", screenWidth - 500, 300);

    public Jogo(int quantos) { 
        dadosImg.add(new ImageView(dado1.getImg()));
        dadosImg.add(new ImageView(dado2.getImg()));
        ocorrendo.setFont(new Font(28));
        ocorrendo.setX(screenWidth-500);
        ocorrendo.setY(screenHeight-600);
        dadosImg.get(0).setX(screenWidth/2);
        dadosImg.get(0).setY(screenHeight/2 + 200);
        dadosImg.get(1).setX(screenWidth/2 + 150);
        dadosImg.get(1).setY(screenHeight/2 + 200);
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
                jogadores.getJogadorById(quemJogando).setCarteira(jogadores.getJogadorById(quemJogando).getCarteira()-50*(1+(int)Math.floor(casas.getCasaCompravelbyId(atual).getCategoria()/10)));
                hipotecar.setDisable(true);
                comprar.setDisable(true);
                melhorar.setDisable(true);
                ocorrendo.setText("Jogador " +(quemJogando+1)+ " melhorou a casa " + atual + "!");
                for(int i = 0; i < jogadores.getNumJogadores();i++) 
                    jogadores.getJogadorById(i).setTexto();
            }
        };

        EventHandler<ActionEvent> eventoHipotecar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int atual = jogadores.getJogadorById(quemJogando).getCasaAtual();
                int atuAluguel = 0;
                if(casas.getCasabyId(jogadores.getJogadorById(quemJogando).getCasaAtual()).getTipo() == 10)
                    atuAluguel = 200;
                else if(casas.getCasabyId(jogadores.getJogadorById(quemJogando).getCasaAtual()).getTipo() == 11)
                    atuAluguel = 100;
                else 
                    atuAluguel = casas.getCasaCompravelbyId(atual).getValorAluguel();
                

                hipotecar.setDisable(true);
                comprar.setDisable(true);
                melhorar.setDisable(true);

                int i = 0;
                //SE EU ESTOU DEVENDO E QUERO HIPOTECAR
                if(casas.getCasabyId(atual).getTipo() == 11 || casas.getCasabyId(atual).getTipo() == 10 || casas.getCasaCompravelbyId(atual).getDono() != quemJogando){
                    while(atuAluguel > jogadores.getJogadorById(quemJogando).getCarteira() && jogadores.getJogadorById(quemJogando).getCasasCompradas().size() != 0) {
                        if(jogadores.getJogadorById(quemJogando).getCasasCompradas().contains(i)){
                            casas.Hipoteca(jogadores.getJogadorById(quemJogando),i);
                            casas.getCasaCompravelbyId(i).atualizarHipotecado();
                            jogadores.hipotecarCasa(quemJogando, i);
                        }
                        i++;
                    }
                    if(atuAluguel > jogadores.getJogadorById(quemJogando).getCarteira()) {
                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " FALIU!");
                        jogadores.eliminarJogador(quemJogando);
                        for(i = 0;i < 40;i++) {
                            if(jogadores.getJogadorById(quemJogando).getCasasHipotecadas().contains(i)) {
                                casas.getCasaCompravelbyId(i).setHipotecado(false);
                                casas.getCasaCompravelbyId(i).setDono(-1);
                                casas.Melhoria(i, 0);
                                tabuleiro.getSeta(i).setVisible(false);
                            }
                        }
                    }
                    
                    else {
                        if(casas.getCasabyId(atual).getTipo() == 10) 
                            jogadores.atualizarCarteira(quemJogando, -200);
                        
                        else if(casas.getCasabyId(jogadores.getJogadorById(quemJogando).getCasaAtual()).getTipo() == 11)
                            atuAluguel = 100;

                        else {
                            jogadores.atualizarCarteira(quemJogando, -tabuleiro.getCasaCIndex(atual).getValorAluguel());
                            jogadores.atualizarCarteira(tabuleiro.getCasaCIndex(atual).getDono(), tabuleiro.getCasaCIndex(atual).getValorAluguel());
                        }
                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " pagou o que devia!");
                    }

                }

                else {
                    casas.HipotecaRemove(jogadores.getJogadorById(quemJogando),atual);
                    casas.getCasaCompravelbyId(atual).atualizarHipotecado();
                    jogadores.DeshipotecarCasa(quemJogando, atual);
                    ocorrendo.setText("Jogador " +(quemJogando+1)+ " deshipotecou a casa "+ atual + "!");
                }
                
                if(dadoIgual) {
                    if(jogadores.getJogadorById(quemJogando).getEstado()) {
                        roleDados.setDisable(false);
                        passeTurno.setDisable(true);
                    }
                    else {
                        roleDados.setDisable(true);
                        passeTurno.setDisable(false);
                    }
                }
                else {
                    roleDados.setDisable(true);
                    passeTurno.setDisable(false);
                }

                for(i = 0; i < jogadores.getNumJogadores();i++) 
                    jogadores.getJogadorById(i).setTexto();
            }
        };

        EventHandler<ActionEvent> eventoComprar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int atual = jogadores.getJogadorById(quemJogando).getCasaAtual();
                jogadores.comprarCasa(quemJogando, atual);
                jogadores.getJogadorById(quemJogando).setCarteira(jogadores.getJogadorById(quemJogando).getCarteira()-tabuleiro.getCasaCIndex(atual).getValorCompra());
                ocorrendo.setText("Jogador "+(quemJogando+1)+ " comprou a casa " + atual + "!");
                if(atual <= 10){
                    tabuleiro.getCasaCIndex(atual).setSeta("application/assets/players/setaC"+quemJogando+".png");
                    tabuleiro.getTodasSetas().get(atual).setImage(new Image(tabuleiro.getCasaCIndex(atual).pathSeta));
                }
                else if(atual > 10 && atual <= 20) {
                    tabuleiro.getCasaCIndex(atual).setSeta("application/assets/players/setaD"+quemJogando+".png");
                    tabuleiro.getTodasSetas().get(atual).setImage(new Image(tabuleiro.getCasaCIndex(atual).pathSeta));
                }
                else if(atual > 20 && atual <= 30) {
                    tabuleiro.getCasaCIndex(atual).setSeta("application/assets/players/setaB"+quemJogando+".png");
                    tabuleiro.getTodasSetas().get(atual).setImage(new Image(tabuleiro.getCasaCIndex(atual).pathSeta));
                }
                else {
                    tabuleiro.getCasaCIndex(atual).setSeta("application/assets/players/setaE"+quemJogando+".png");
                    tabuleiro.getTodasSetas().get(atual).setImage(new Image(tabuleiro.getCasaCIndex(atual).pathSeta));
                }
                tabuleiro.getSeta(atual).setVisible(true);
                if(casas.temMonopolio(casas.getCasaCompravelbyId(atual).getTipo(), jogadores.getJogadorById(quemJogando)) && jogadores.getJogadorById(quemJogando).getCarteira() >= 50*(1+Math.floor(atual/10)))
                    melhorar.setDisable(false);
                else
                    melhorar.setDisable(true);
                    
                //SE CASA NAO FOR TERRENO E SIM EMPRESA
                if(casas.getCasaCompravelbyId(atual).getTipo() == 9) {
                    melhorar.setDisable(true);
                    int i = 0, cont = 0;
                    while(i < 40) {
                        if(jogadores.getJogadorById(quemJogando).getCasasCompradas().contains(i)) {
                            if(casas.getCasaCompravelbyId(i).getTipo() == 9) {
                                cont++;
                            }
                        }
                        i++;
                    }
                    i = 0;
                    while(i < 40) {
                        if(jogadores.getJogadorById(quemJogando).getCasasCompradas().contains(i)) {
                            if(casas.getCasaCompravelbyId(i).getTipo() == 9) {
                                casas.Melhoria(i, cont);
                            }
                        }
                        i++;
                    }
                }
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
                int remove = -1;
                quemJogando = tabuleiro.getFirstOrdem();
                while(!jogadores.getJogadorById(quemJogando).getEstado()) {
                    remove = tabuleiro.getFirstOrdem();
                    tabuleiro.atualizaOrdem();
                    quemJogando = tabuleiro.getFirstOrdem();
                    tabuleiro.removeDaOrdem(remove);
                }
                jogadores.alterarVisibilidade(quemJogando);
                if(tabuleiro.getOrdem().size() == 1) {
                    /*CÓDIGO PARA TERMINAR O JOGO (NAO ENTENDI BEM COMO FAZER A LOGICA DAS VISIBILIDADES, FAREI DEPOIS)*/
                    System.out.println("O JOGO FOI VENCIDO PELO JOGADOR "+quemJogando+"!!!!!!!!!!");
                }
                passeTurno.setDisable(true);
                hipotecar.setDisable(true);
                comprar.setDisable(true);
                roleDados.setDisable(false);
                melhorar.setDisable(true);
                ocorrendo.setText("Rodada do jogador "+ (quemJogando+1));
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
                    //SE O JOGADOR ATUAL NÃO ESTÁ PRESO
                    if(!jogadores.getJogadorById(quemJogando).getPreso()){
                        jogadores.desenharJogador(quemJogando, dado1.valorDado()+dado2.valorDado(),casas);
                        jogadores.atualizarCasaAtual(quemJogando,dado1.valorDado()+dado2.valorDado());
                        int atual = jogadores.getJogadorById(quemJogando).getCasaAtual();
                        ocorrendo.setText("Jogador "+ (quemJogando+1) + " caiu na casa " + atual + "!");
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
                                    //SE A CASA PODE SER DESHIPOTECADA
                                    if(tabuleiro.getCasaCIndex(atual).getHipotecado() && jogadores.getJogadorById(quemJogando).getCarteira() > 6*(tabuleiro.getCasaCIndex(atual).getValorCompra())/10) 
                                        hipotecar.setDisable(false);
                                    
                                    else{
                                        hipotecar.setDisable(true);
                                        //SE A CASA PODE SER MELHORADA
                                        if(tabuleiro.getCasaCIndex(atual).getTipo() != 9 && (tabuleiro.getCasaCIndex(atual).getCategoria() > 0 || tabuleiro.getCasaCIndex(atual).getCategoria() < 6)) {
                                            //SE O JOGADOR POSSUI DINHEIRO PARA MELHORAR
                                            if(casas.temMonopolio(casas.getCasaCompravelbyId(atual).getTipo(), jogadores.getJogadorById(quemJogando)) && jogadores.getJogadorById(quemJogando).getCarteira() >= 2*tabuleiro.getCasaCIndex(atual).getValorAluguel()) 
                                                melhorar.setDisable(false);
                                            else
                                                melhorar.setDisable(true);
                                        }
                                    }
                                }
                                //SE O DONO É OUTRO JOGADOR
                                else {
                                    melhorar.setDisable(true);
                                    //SE A CASA NAO ESTA HIPOTECADA
                                    if(!casas.getCasaCompravelbyId(atual).getHipotecado()) {
                                        //SE O JGOADOR NAO POSSUE DINHEIRO PARA PAGAR O ALUGUEL (AINDA INCOMPLETO, PRECISO PENSAR NA LÓGICA)
                                        if(jogadores.getJogadorById(quemJogando).getCarteira() < tabuleiro.getCasaCIndex(atual).getValorAluguel()) {
                                            hipotecar.setDisable(false);
                                            comprar.setDisable(true);
                                            ocorrendo.setText("Jogador "+ quemJogando + " está devendo para o dono da casa " + atual + "!");
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
                        //SE A CASA APENAS TIRA DINHEIRO DO JOGADOR
                        else if(tabuleiro.getCasaIndex(atual).getTipo() == 10) {
                            comprar.setDisable(true);
                            hipotecar.setDisable(true);
                            melhorar.setDisable(true);
                            if(jogadores.getJogadorById(quemJogando).getCarteira() >= 200)
                                jogadores.atualizarCarteira(quemJogando, -200);
                            else  {
                                hipotecar.setDisable(false);
                                ocorrendo.setText("Jogador " +(quemJogando+1)+ " não tem dinheiro para pagar a taxa!");
                            }
                        }
                        //SE A CASA NAO É COMPRÁVEL 
                        else {
                            comprar.setDisable(true);
                            hipotecar.setDisable(true);
                            melhorar.setDisable(true);
                            ArrayList<Integer> retorno;
                            if(casas.getCasabyId(atual).getTipo() == 11) {
                                retorno = casas.getCasabyId(atual).getCarta().acaoCarta(jogadores, casas, quemJogando);
                                switch(retorno.get(0)) {
                                    case 0:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " voltou ao início!");
                                        break;
                                    case 1:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " ganhou I$ 100!");
                                        break;
                                    case 2:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " perdeu I$ 100!");
                                        break;
                                    case 3:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " foi visitar os processados!");
                                        break;
                                    case 4:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " foi comprar um doce!");
                                        break;
                                    case 5:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " tomou falta!");
                                        break;
                                    case 6:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " tem uma aula vaga!");
                                        break;
                                    case 7:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " voltou 3 casas!");
                                        break;
                                    case 8:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " pulou 5 casas!");
                                        break;
                                    default:
                                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " tomou processo administrativo!");
                                        break;
                                }
                                if(retorno.size() == 2) {
                                    hipotecar.setDisable(false);
                                }
                            }
                            
                            if(atual == 30) {
                                jogadores.getJogadorById(quemJogando).setPreso(true);
                                jogadores.desenharJogador(quemJogando, 20,casas);
                                jogadores.atualizarCasaAtual(quemJogando, 20);
                                jogadores.atualizarCarteira(quemJogando, -200);
                                ocorrendo.setText("Jogador " +(quemJogando+1)+ " tomou processo administrativo!");
                            }
                        }
                    }
                    //SE O JOGADOR ATUAL ESTIVER PRESO
                    else {
                        comprar.setDisable(true);
                        hipotecar.setDisable(true);
                        melhorar.setDisable(true);
                        ocorrendo.setText("Jogador " +(quemJogando+1)+ " está em processo!");
                    }
                    //SE O JOGADOR TEVE UMA ROLAGEM DE 2 DADOS IGUAIS (REPETE A RODADA)
                    if(dadoIgual) {
                        //SOLTA ELE DA PRISAO
                        if(hipotecar.isDisable()) {
                            jogadores.getJogadorById(quemJogando).setPreso(false);
                            roleDados.setDisable(false);
                            passeTurno.setDisable(true);
                        }
                        else {
                            roleDados.setDisable(true);
                            passeTurno.setDisable(true);
                        }
                    }
                    else {
                        roleDados.setDisable(true);
                        if(hipotecar.isDisable())
                            passeTurno.setDisable(false);
                        else
                            passeTurno.setDisable(true);
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

    }

    public void resetarJogo(int quantos) {
        dadosImg.add(new ImageView(dado1.getImg()));
        dadosImg.add(new ImageView(dado2.getImg()));
        ocorrendo.setFont(new Font(28));
        ocorrendo.setX(screenWidth-500);
        ocorrendo.setY(screenHeight-600);
        dadosImg.get(0).setX(screenWidth/2);
        dadosImg.get(0).setY(screenHeight/2 + 200);
        dadosImg.get(1).setX(screenWidth/2 + 150);
        dadosImg.get(1).setY(screenHeight/2 + 200);
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

    }
}
