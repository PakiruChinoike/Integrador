import java.util.ArrayList;

public class Guerreiro extends Classe {

    private ArrayList<Habilidade> listaHabilidades;

    public Guerreiro(int tipo) {
        super(tipo);
        this.listaHabilidades = new ArrayList<Habilidade>(4);
    }

}