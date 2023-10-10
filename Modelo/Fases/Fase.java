import java.util.List;
import java.util.ArrayList;

public class Fase{

    private int id;
    private String nome;
    private List<Sala> listaSalas;
    private int salaAtual;
    private Equipe party;

    public Fase(String nome, List<Sala> listaSalas) {
        this.nome = nome;
        this.listaSalas = new ArrayList<Sala>();
        this.listaSalas.addAll(listaSalas);
        salaAtual = 0;
        listaSalas.get(salaAtual).entraSala(party);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String prossegueSala() {
        salaAtual++;
        return listaSalas.get(salaAtual).entraSala(party);
    }

}