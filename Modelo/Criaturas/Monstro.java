import java.util.List;

public class Monstro extends Criatura{
    
    private long id;

    public Monstro(String nome, int vida, int armadura, int nivel, List<Boolean> fraquezas, List<Integer> atributos, List<Habilidade> habilidades) {
        super(nome, vida, armadura, nivel, fraquezas, atributos, habilidades);
    }

    public long getId() {
        return id;
    }

}
