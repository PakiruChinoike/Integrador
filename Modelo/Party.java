import java.util.ArrayList;

public class Party extends Equipe{
    
    private ArrayList<Personagem> personagens;

    public Party(int id, ArrayList<Personagem> personagens) {
        super(id);
        this.personagens = new ArrayList<Personagem>();
        this.personagens.addAll(personagens);
    }

    public Personagem getPersonagem(int index) {
    return personagens.get(index);
    }

}
