import java.util.ArrayList;
import java.util.List;

public class Sala{

    private int id;
    private int dificuldade;
    private String descricao;
    private List<Monstro> inimigos;
    private Recompensa recompensa;

    public Sala(int id, int dificuldade, String descricao, List<Monstro> inimigos, Recompensa recompesa) {
        this.id = id;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.recompensa = recompesa;

        this.inimigos = new ArrayList<Monstro>();
        this.inimigos.addAll(inimigos);
    }

    public int getId() {
        return id;
    }

    public String entraSala(Equipe party) {
        return party.getPersonagem(0).getNome() + ", " + party.getPersonagem(1).getNome() + " e " + party.getPersonagem(2).getNome() +
        "entram na sala adiante. " + descricao;
    }

}