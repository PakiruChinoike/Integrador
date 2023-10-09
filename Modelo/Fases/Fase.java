import java.util.List;
import java.util.ArrayList;

public class Fase{

    private List<Sala> listaSalas;
    private int salaAtual;
    private Equipe party;

    public Fase(List<Sala> listaSalas) {
        this.listaSalas = new ArrayList<Sala>();
        this.listaSalas.addAll(listaSalas);
        salaAtual = 0;
        listaSalas.get(salaAtual).entraSala(party);
    }

    public String prossegueSala() {
        salaAtual++;
        return listaSalas.get(salaAtual).entraSala(party);
    }

}