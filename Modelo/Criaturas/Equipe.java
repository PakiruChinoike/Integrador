import java.util.ArrayList;
import java.util.List;

public class Equipe {
    
    private long id;
    private List<Personagem> personagens;

    //UM CONSTRUTOR QUE CRIA UMA EQUIPE DE APENAS UM PERSONAGEM
    public Equipe(int id, Personagem personagem) {
        this.id = id;
        this.personagens = new ArrayList<Personagem>(3);
        this.personagens.add(personagem);
    }

    //UM 
    public Equipe(int id, ArrayList<Personagem> personagens) {
        this.id = id;
        this.personagens = new ArrayList<Personagem>(3);
        this.personagens.addAll(personagens);
    }

    public long getId() {
        return id;
    }

    public Personagem getPersonagem(int index) {
        return personagens.get(index);
    }

    public void addPersonagem(Personagem personagem) {
        this.personagens.add(personagem);
    }

    public void removerPersonagem(Personagem personagem) {
        this.personagens.remove(personagem);
    }

}
