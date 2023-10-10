import java.util.List;

public class Monstro extends Criatura{
    
    private int id;

    public Monstro(String nome, int vida, int armadura, int nivel, List<Boolean> fraquezas, List<Integer> atributos, List<Habilidade> habilidades) {
        super(nome, vida, armadura, nivel, fraquezas, atributos, habilidades);
    }

    public int getId() {
        return id;
    }

}
