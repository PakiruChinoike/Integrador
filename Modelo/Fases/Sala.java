import java.util.ArrayList;
import java.util.List;

public class Sala{

    private long id;
    private String nome;
    private String descricao;
    private List<Criatura> inimigos;
    private Recompensa recompensa;

    public Sala() {
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.recompensa = new Recompensa();

        this.inimigos = new ArrayList<Criatura>();
    }

    public Sala(long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

        this.inimigos = new ArrayList<Criatura>();
    }

    public Sala(long id, String nome, String descricao, Recompensa recompesa, List<Criatura> inimigos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.recompensa = recompesa;

        this.inimigos = new ArrayList<Criatura>();
        this.inimigos.addAll(inimigos);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void addInimigos(Criatura inimigo) {
        inimigos.add(inimigo);
    }

    public void addInimigos(List<Criatura> inimigos) {
        inimigos.addAll(inimigos);
    }

    public List<Criatura> getInimigos() {
        return inimigos;
    }

    public Criatura getInimigo(int index) {
        return inimigos.get(index);
    }

}