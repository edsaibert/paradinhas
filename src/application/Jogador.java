import java.util.HashSet
import javafx.scene.image.Image;

// TEMATICA POLITECNICO
// ao inves de casas, vao ser as salas
// ao inves de dinheiro podemos trabalhar com IRA
// as propriedades/casas compradas podem ser as disciplinas

public class Jogador
{
    private int id; // numero identificador do jogador
    private int casa; // numero da casa atual
    private int dinheiro; // dinheiro total
    private boolean ativo; // se pode jogar ou nao

    // conjunto das propriedades (casas compraveis) que o jogador possui  
    // a string se refere ao nome da propriedade
    private HashSet<String> prop; // propriedades


    // construtor do jogador (inicializador)
    public Jogador(int id)
    {
        this.id = id;
        this.casa = 0; // inicia na casa 0
        this.dinheiro = 25000;
        this.ativo = true;
        this.prop = new HashSet<String>();
    }
    
    // anda "num_casas" posicoes com o jogador
    // nao verifica se completou a volta
    public void movimenta(int num_casas)
    {
        this.casa = this.casa + num_casas;
    }


    
}
