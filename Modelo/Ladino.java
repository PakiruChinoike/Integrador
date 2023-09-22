import java.util.ArrayList;

public class Ladino extends Classe {

    private ArrayList<Habilidade> listaHabilidades;

    public Ladino(int tipo) {
        super(tipo);
        this.listaHabilidades = new ArrayList<Habilidade>(4);
    }

}