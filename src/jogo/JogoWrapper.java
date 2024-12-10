package jogo;

import java.io.Serializable;

public class JogoWrapper implements Serializable{
    public Jogo game;

    public JogoWrapper (Jogo game) { this.game = game; }

    public Jogo getGame() { return this.game; }

    public void setGame(Jogo game) { this.game = game; }
}
