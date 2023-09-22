public class Equipe {
    
    private int id;
    private ArrayList<Personagem> personagens;

    public Equipe(ArrayList<Personagem> personagens) {
        this.personagens = new ArrayList<Personagem>(3);
        this.personagens.addAll(personagens);
    }

    public int getId() {
        return id;
    }

    public Personagem getPersonagem(int index) {
        return personagens.get(index);
    }

}
