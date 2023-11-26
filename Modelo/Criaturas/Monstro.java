import java.util.List;

public class Monstro extends Criatura{
    
    private long id;
    
    //UM CONSTRUTOR QUE RECEBE NOME, VIDA, ARMADURA E NIVEL
    public Monstro(String nome, int vida, int armadura, int nivel, int equipe) {
        super(nome, vida, armadura, nivel, equipe);
        id = 0;
    }

    //UM CONSTRUTOR QUE RECEBE TODOS ATRIBUTOS DE UM MONSTRO 
    public Monstro(String nome, int vida, int armadura, int nivel, List<Boolean> fraquezas, List<Integer> atributos, List<Habilidade> habilidades, Equipe equipe) {
        super(nome, vida, armadura, nivel, fraquezas, atributos, habilidades, equipe);
        id = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
