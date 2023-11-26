import java.util.ArrayList;
import java.util.List;

public class Equipe {
    
    private long id;
    private List<Criatura> criaturas;

    //UM CONSTRUTOR QUE CRIA UMA EQUIPE DE APENAS UMA CRIATURA
    public Equipe(int id, Criatura criatura) {
        this.id = id;
        this.criaturas = new ArrayList<Criatura>(3);
        this.criaturas.add(criatura);
        criatura.setEquipe(id);
    }

    //UM 
    public Equipe(int id, List<Criatura> criaturas) {
        this.id = id;
        this.criaturas = new ArrayList<Criatura>(3);
        this.criaturas.addAll(criaturas);

        for(int i = 0; i<criaturas.size(); i++) {
            criaturas.get(i).setEquipe(id);
        }
    }

    public long getId() {
        return id;
    }

    public Criatura get(int index) {
        return criaturas.get(index);
    }

    public int size() {
        return criaturas.size();
    }

    public void addCriatura(Criatura criatura) {
        this.criaturas.add(criatura);
    }

    public void removerCriatura(Criatura criatura) {
        this.criaturas.remove(criatura);
    }

}
