import java.util.List;
import java.util.ArrayList;

public class Fase{

    private long id;
    private String nome;
    private List<Sala> listaSalas;
    private Equipe equipe;

    public Fase(String nome, List<Sala> listaSalas) {
        this.nome = nome;
        this.listaSalas = new ArrayList<Sala>();
        this.listaSalas.addAll(listaSalas);
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

    public List<Sala> getListaSalas() {
        return listaSalas;
    }

    public Sala getSala(int index) {
        return listaSalas.get(index);
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}