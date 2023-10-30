import java.util.ArrayList;
import java.util.List;

public class Sala{

    private long id;
    private int dificuldade;
    private int tipo;
    private String descricao;
    private List<Monstro> inimigos;
    private Recompensa recompensa;

    public Sala(int id, int tipo, int dificuldade, String descricao, List<Monstro> inimigos, Recompensa recompesa) {
        this.id = id;
        this.tipo = tipo;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.recompensa = recompesa;

        this.inimigos = new ArrayList<Monstro>();
        this.inimigos.addAll(inimigos);
    }

    public long getId() {
        return id;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public int getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Monstro> getInimigos() {
        return inimigos;
    }

    public String entraSala(Equipe party) {
        return party.getPersonagem(0).getNome() + ", " + party.getPersonagem(1).getNome() + " e " + party.getPersonagem(2).getNome() +
        "entram na sala adiante. " + descricao;
    }

    public String isDerrotado() {
        if(inimigos.isEmpty()) {
            return "Todos os inimigos foram derrotados! A sua equipe recebeu: " + recompensa.toString();
        }
        else {
            return null;
        }
    }

}