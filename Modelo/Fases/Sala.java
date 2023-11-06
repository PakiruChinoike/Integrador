import java.util.ArrayList;
import java.util.List;

public class Sala{

    private long id;
    private int tipo;
    private int dificuldade;
    private String nome;
    private String descricao;
    private List<Monstro> inimigos;
    private Recompensa recompensa;

    public Sala() {
        this.id = 0;
        this.tipo = 0;
        this.dificuldade = 0;
        this.nome = "";
        this.descricao = "";
        this.recompensa = new Recompensa();

        this.inimigos = new ArrayList<Monstro>();
    }

    public Sala(int id, int tipo, int dificuldade, String nome, String descricao, Recompensa recompesa, List<Monstro> inimigos) {
        this.id = id;
        this.tipo = tipo;
        this.dificuldade = dificuldade;
        this.nome = nome;
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

    public String getNome() {
        return nome;
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